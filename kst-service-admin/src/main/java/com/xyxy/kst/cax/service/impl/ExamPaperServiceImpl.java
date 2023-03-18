package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ExamPaperDao;
import com.xyxy.kst.cax.dao.QuestionDao;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.*;
import com.xyxy.kst.cax.service.*;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamPaperTitleItemVM;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/20:31
 */
@Service
public class ExamPaperServiceImpl extends ServiceImpl<ExamPaperDao, ExamPaper> implements ExamPaperService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventLogService userEventLogService;

    @Autowired
    private ExamPaperAnswerService examPaperAnswerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TaskExamService taskExamService;

    @Autowired
    private QuestionDao questionDao;
    /**
     * 获取到试卷卷总数
     */
    @Override
    public Integer getExamPaperCount(){
        Integer examPaperCount = baseMapper.selectCount(null);
        return examPaperCount;
    }

    /**
     * 分页条件查询
     * @param page
     * @param examVM
     * @return
     */
    @Override
    public Map<String, Object> getExamPaperPage(Page<ExamPaper> page, ExamVM examVM) {
        IPage<ExamPaper> examPaperPage = baseMapper.getExamPaperPage(page, examVM);
        List<ExamPaper> examPaperList = examPaperPage.getRecords();
        long total = examPaperPage.getTotal();
        long pageNum = examPaperPage.getCurrent();
        Map<String, Object> map = new HashMap<>();
        map.put("list", examPaperList);
        map.put("total", total);
        map.put("pageNum", pageNum);
        return map;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public ExamPaper selectExamPaper(Integer id) {
        ExamPaper examPaper = baseMapper.selectById(id);
        return examPaper;
    }

    /**
     * 添加或者修改考试试卷
     * @param examVM
     * @return
     */
    @Transactional
    @Override
    public String createOrUpdateExamPaper(ExamVM examVM) {
//        System.out.println("**************************");
        String jsonStr = JsonUtil.toJsonStr(examVM);
        ExamPaper examPaper1 = JsonUtil.toJsonObject(jsonStr, ExamPaper.class);
        examPaper1.setGradeLevel(examVM.getLevel());
//        System.out.println("=====================>"+examVM.getLimitDateTime().toString());
        if (examVM.getPaperType() == 4){
            examPaper1.setLimitStartTime(DateTimeUtil.parse(examVM.getLimitDateTime().get(0), "yyyy-MM-dd HH:mm:ss"));
            examPaper1.setLimitEndTime(DateTimeUtil.parse(examVM.getLimitDateTime().get(1), "yyyy-MM-dd HH:mm:ss"));
        }
        examPaper1.setTextContent(JsonUtil.toJsonStr(examVM.getTitleItems()));
        ExamPaper examPaper = baseMapper.selectById(examVM.getId());
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        // 计算试卷的总分数，以及改试卷的题目数量
        List<ExamPaperTitleItemVM> titleItems = examVM.getTitleItems();
        int sumScores = 0;
        int count = 0;
        for (ExamPaperTitleItemVM titleItem : titleItems) {
            List<QuestionEditRequestVM> questionItems = titleItem.getQuestionItems();
            for (QuestionEditRequestVM questionEditRequestVM : questionItems){
                Question question = questionService.getById(questionEditRequestVM.getId());
                sumScores += question.getScore();
                count++;
            }
        }
        examPaper1.setScore(sumScores);
        examPaper1.setQuestionCount(count);
        if (examPaper == null){
            examPaper1.setCreateTime(new Date());
            examPaper1.setCreateUser(loginUser.getUsername());
            User user = userService.getUserByUserName(loginUser.getUsername());
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setCreateTime(new Date());
            switch (examVM.getPaperType()){
                case 1 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个固定试卷,试卷名称:"+examVM.getName());
                    break;
                case 4 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个时段试卷,试卷名称:"+examVM.getName());
                    break;
                case 6 :
                    userEventLog.setContent(loginUser.getUsername()+"创建了一个任务试卷,试卷名称:"+examVM.getName());
                    break;
            }
            userEventLogService.saveUserEventLog(userEventLog);
            int insert = baseMapper.insert(examPaper1);
            return "添加试卷成功";
        }else {
            User user = userService.getUserByUserName(loginUser.getUsername());
            int update = baseMapper.updateById(examPaper1);
            if (update>0){
                UserEventLog userEventLog = new UserEventLog();
                userEventLog.setUserId(user.getId());
                userEventLog.setUserName(user.getUserName());
                userEventLog.setRealName(user.getRealName());
                userEventLog.setCreateTime(new Date());
                userEventLog.setContent(user.getUserName()+"更新了"+examVM.getName()+"试卷");
                userEventLogService.saveUserEventLog(userEventLog);
                if (examPaper1.getTaskExamId() != null){
                    TaskExam taskExam = taskExamService.getById(examPaper1.getTaskExamId());
                    List<ExamPaperTitleItemVM> ExamPaperTitleItemVMs = JsonUtil.toJsonListObject(examPaper1.getTextContent(), ExamPaperTitleItemVM.class);
                    List<ExamVM> examVMS = JsonUtil.toJsonListObject(taskExam.getTextContent(), ExamVM.class);
                    for (ExamVM examVM1 : examVMS){
                        if (examVM1.getId() == examPaper1.getId()){
                            examVM1.setTitleItems(ExamPaperTitleItemVMs);
                        }
                    }
                    String jsonStr1 = JsonUtil.toJsonStr(examVMS);
                    LambdaUpdateWrapper<TaskExam> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
                    lambdaUpdateWrapper.set(TaskExam::getTextContent, jsonStr1);
                    lambdaUpdateWrapper.eq(TaskExam::getId, examPaper1.getTaskExamId());
                    taskExamService.update(lambdaUpdateWrapper);
                }
            }
            return "修改试卷成功";
        }
    }

    /**
     * 更新状态
     * @param id
     * @return
     */
    @Override
    public String changeStatus(Integer id) {
        ExamPaper examPaper = baseMapper.selectById(id);
        if (examPaper != null){
            Integer status = examPaper.getStatus() == 1 ? 2 : 1;
            examPaper.setStatus(status);
            baseMapper.updateById(examPaper);
            return "编辑成功";
        }else {
            return "编辑失败";
        }
    }

    /**
     * 删除试卷
     * @param id
     * @return
     */
    @Override
    public String deletePaper(Integer id) {
        ExamPaper examPaper = baseMapper.selectById(id);
        if (examPaper != null) {
            if (examPaper.getTaskExamId() != null){
                return "该试卷已在任务中，不可以删除";
            }else {
                baseMapper.deleteById(id);
                return "删除成功";
            }
        }else {
            return "删除失败";
        }
    }

    @Override
    public Map<String, Object> taskExamPage(ExamVM examVM) {
        Page<ExamPaper> page = new Page<>(examVM.getPageIndex(), examVM.getPageSize());
        IPage<ExamPaper> examPagePage = baseMapper.taskExamPage(page, examVM);
        List<ExamPaper> list = examPagePage.getRecords();
        List<ExamVM> examVMS = new ArrayList<>();
        
        for (ExamPaper examPaper : list){
            ExamVM examVM1 = new ExamVM();
            examVM1.setLevel(examPaper.getGradeLevel());
            List<ExamPaperTitleItemVM> titleItems = JsonUtil.toJsonListObject(examPaper.getTextContent(), ExamPaperTitleItemVM.class);
            examVM1.setTitleItems(titleItems);
            examVM1.setSubjectId(examPaper.getSubjectId());
            examVM1.setPaperType(examPaper.getPaperType());
            examVM1.setSuggestTime(examPaper.getSuggestTime());
            examVM1.setName(examPaper.getName());
            List<String> dates = new ArrayList<>();
            dates.add(DateTimeUtil.dateFormat(examPaper.getLimitStartTime()));
            dates.add(DateTimeUtil.dateFormat(examPaper.getLimitEndTime()));
            examVM1.setLimitDateTime(dates);
            examVM1.setId(examPaper.getId());
            examVMS.add(examVM1);
        }
        long pageNum = examPagePage.getCurrent();
        long total = examPagePage.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("list", examVMS);
        map.put("pageNum", pageNum);
        map.put("total", total);
        return map;
    }


    /**
     * 遗传算法组卷
     *
     * @param difficulty 题目难度，取值为 1-5
     * @param questionCount 题目数量
     * @param subjectId 学科ID
     * @param gradeLevel 年级，取值为 1-12
     * @return 试卷题目列表
     */
    @Override
    public List<Question> generatePaper(int difficulty, int questionCount, int subjectId, int gradeLevel) {
        // 调用mybatis-plus的查询构造器，查询符合条件的题目列表
        List<Question> questionList = questionDao.selectList(new QueryWrapper<Question>()
                .eq("subject_id", subjectId) // 指定学科ID
                .eq("grade_level", gradeLevel) // 指定年级
                .eq("difficult", difficulty) // 指定难度
                .orderByAsc("score") // 按照分数升序排序
                .last("limit " + questionCount * 10)); // 指定题目数量，取前 N 个

        // 如果查询到的题目数量不足，则返回空列表
        if (questionList.size() < questionCount) {
            return Collections.emptyList();
        }

        // 初始化种群，即将随机生成的试卷
        List<List<Integer>> population = new ArrayList<>();
        for (int i = 0; i < 50; i++) { // 种群数量为 50
            List<Integer> chromosome = new ArrayList<>();
            for (int j = 0; j < questionCount; j++) {
                chromosome.add(j);
            }
            Collections.shuffle(chromosome); // 随机打乱顺序
            population.add(chromosome);
        }

        // 开始遗传算法迭代
        for (int i = 0; i < 1000; i++) { // 迭代次数为 1000
            List<Integer> scores = new ArrayList<>(); // 记录种群中每个个体的适应度分数
            for (List<Integer> chromosome : population) {
                int score = calculateScore(questionList, chromosome); // 计算适应度分数
                scores.add(score);
            }
            List<List<Integer>> newPopulation = new ArrayList<>(); // 新的种群，即下一代的个体
            for (int j = 0; j < 50; j++) { // 下一代的种群数量仍为 50
                // 选择操作，选出两个适应度分数高的个体
                int index1 = select(scores);
                int index2 = select(scores);
                // 交叉操作，将两个个体的染色体交叉生成新的个体
                List<Integer> chromosome1 = population.get(index1);
                List<Integer> chromosome2 = population.get(index2);
                List<Integer> newChromosome = crossover(chromosome1, chromosome2);
                // 变异操作，以一定概率对新个体进行变异
                mutate(newChromosome);
                newPopulation.add(newChromosome);
            }
            population = newPopulation;
        }

        // 计算最终的适应度分数并返回试卷题目列表
        int maxScore = Integer.MIN_VALUE;
        List<Integer> maxChromosome = null;
        for (List<Integer> chromosome : population) {
            int score = calculateScore(questionList, chromosome);
            if (score > maxScore) {
                maxScore = score;
                maxChromosome = chromosome;
            }
        }

        // 去重并随机选择题目
        Set<Integer> indexSet = new HashSet<>();
        while (indexSet.size() < questionCount) {
            int index = (int) (Math.random() * questionList.size());
            indexSet.add(index);
        }

        List<Question> paper = new ArrayList<>();
        for (int index : indexSet) {
            paper.add(questionList.get(index));
        }
        return paper;
    }

    /**
     * 计算个体的适应度分数
     *
     * @param questionList 题目列表
     * @param chromosome 染色体
     * @return 适应度分数
     */
    private int calculateScore(List<Question> questionList, List<Integer> chromosome) {
        int totalScore = 0;
        int totalDifficult = 0;
        for (int index : chromosome) {
            totalScore += questionList.get(index).getScore();
            totalDifficult += questionList.get(index).getDifficult();
        }
        int averageDifficult = totalDifficult / chromosome.size();
        return totalScore * (5 - Math.abs(averageDifficult));
    }

    /**
     * 选择操作，按照轮盘赌算法选择一个个体
     *
     * @param scores 种群中每个个体的适应度分数
     * @return 选中的个体的索引
     */
    private int select(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        int threshold = (int) (Math.random() * sum); // 生成随机阈值
        int index = 0;
        int acc = 0;
        for (int score : scores) {
            acc += score;
            if (acc > threshold) {
                return index;
            }
            index++;
        }
        return index - 1;
    }

    /**
     * 交叉操作，将两个个体的染色体交叉生成新的个体
     *
     * @param chromosome1 个体1的染色体
     * @param chromosome2 个体2的染色体
     * @return 新的个体的染色体
     */
    private List<Integer> crossover(List<Integer> chromosome1, List<Integer> chromosome2) {
        int length = chromosome1.size();
        int crossoverPoint = (int) (Math.random() * (length - 1)) + 1; // 生成随机交叉点
        List<Integer> newChromosome = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (i < crossoverPoint) {
                newChromosome.add(chromosome1.get(i));
            } else {
                newChromosome.add(chromosome2.get(i));
            }
        }
        return newChromosome;
    }

    /**
     * 随机选择染色体中的一个基因，并以一定概率将其改变为另一个可能的值。
     *
     * @param chromosome 染色体，即试卷题目的顺序
     */
    private void mutate(List<Integer> chromosome) {
        // 随机选择一个基因
        int index = (int) (Math.random() * chromosome.size());
        // 以一定概率进行变异
        if (Math.random() < 0.1) {
            // 随机选择另一个可能的值，并将其与原来的值交换位置
            int newIndex = (int) (Math.random() * chromosome.size());
            Collections.swap(chromosome, index, newIndex);
        }
    }
}

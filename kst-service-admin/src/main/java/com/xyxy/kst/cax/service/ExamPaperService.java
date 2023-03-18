package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.viewmodel.admin.dashboard.IndexVM;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;

import java.util.List;
import java.util.Map;

public interface ExamPaperService extends IService<ExamPaper> {
    /**
     * 获取试卷总数
     * @return
     */
    Integer getExamPaperCount();

    /**
     * 分页条件查询
     * @param page
     * @param examVM
     * @return
     */
    Map<String, Object> getExamPaperPage(Page<ExamPaper> page, ExamVM examVM);

    /**
     * 根据id查询考试试卷
     * @param id
     * @return
     */
    ExamPaper selectExamPaper(Integer id);

    /**
     * 创建或者修改考试试卷
     * @param examVM
     * @return
     */
    String createOrUpdateExamPaper(ExamVM examVM);

    /**
     * 更新状态
     * @param id
     * @return
     */
    String changeStatus(Integer id);

    /**
     * 删除试卷
     * @param id
     * @return
     */
    String deletePaper(Integer id);

    /**
     * 分页条件查询，判断状态
     * @param examVM
     * @return
     */
    Map<String, Object> taskExamPage(ExamVM examVM);

    /**
     * 遗传算法组卷
     *
     * @param difficulty 题目难度，取值为 1-5
     * @param questionCount 题目数量
     * @param subjectId 学科ID
     * @param gradeLevel 年级，取值为 1-12
     * @return 试卷题目列表
     */
    public List<Question> generatePaper(int difficulty, int questionCount, int subjectId, int gradeLevel);
}

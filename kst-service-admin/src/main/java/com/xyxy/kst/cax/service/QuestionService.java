package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;

import java.util.Map;

public interface QuestionService extends IService<Question> {
    /**
     * 获取问题的数量
     * @return
     */
    Integer getQuestionCount();

    /**
     * 分页条件查询
     * @param pageAndSearch
     * @return
     */
    Map<String, Object> getQuestionPage(PageAndSearch pageAndSearch);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    QuestionEditRequestVM selectQuestionById(Integer id);

    /**
     * 创建或者更新题目
     * @param questionEditRequestVM
     * @return
     */
    String createOrUpdateQuestion(QuestionEditRequestVM questionEditRequestVM);

    /**
     * 删除问题
     * @param id
     * @return
     */
    String deleteQuestion(Integer id);
}

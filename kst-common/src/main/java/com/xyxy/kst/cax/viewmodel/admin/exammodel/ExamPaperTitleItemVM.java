package com.xyxy.kst.cax.viewmodel.admin.exammodel;

import com.xyxy.kst.cax.viewmodel.admin.question.QuestionEditRequestVM;
import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/21/10:15
 */
@Data
public class ExamPaperTitleItemVM {
    // 标题
    private String name;
    // 题目
    private List<QuestionEditRequestVM> questionItems;
}

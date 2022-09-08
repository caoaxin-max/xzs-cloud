package com.xyxy.kst.cax.viewmodel.student.examPaperAnswer;

import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/13/9:20
 */
@Data
public class ExamPaperDoAnswerVM {
    private Integer epqCustomerAnswerId;
    private String content;
    private List<String> contentArray;
    private Integer questionId;
    private Boolean doRight;
    // 排序
    private Integer itemOrder;
    // 本题得分
    private Integer score;
}

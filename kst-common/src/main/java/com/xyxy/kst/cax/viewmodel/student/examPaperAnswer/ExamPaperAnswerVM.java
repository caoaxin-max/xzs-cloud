package com.xyxy.kst.cax.viewmodel.student.examPaperAnswer;

import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/13/9:17
 */
@Data
public class ExamPaperAnswerVM {
    // 试卷id
    private Integer id;
    // 做题时间(秒)
    private Integer doTime;
    // 试卷得分
    private Integer score;
    // 答案
    private List<ExamPaperDoAnswerVM> answerItems;
}

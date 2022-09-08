package com.xyxy.kst.cax.viewmodel.admin.dashboard;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/25/8:33
 */
@Data
public class IndexVM {

    /**
     * 试卷总数
     * */
    private Integer examPaperCount;
    /**
     * 题目总数
     * */
    private Integer questionCount;
    /**
     * 做了的试卷数量
     * */
    private Integer doExamPaperCount;
    /**
     * 做了的题目数量
     * */
    private Integer doQuestionCount;
    /**
     * 该月用户的活跃度
     * */
    private List<Integer> mothDayUserActionValue;
    /**
     * 每月写题目的数量
     */
    private List<Integer> mothDayDoExamQuestionValue;
    /**
     * 日期
     */
    private List<String> mothDayText;
}

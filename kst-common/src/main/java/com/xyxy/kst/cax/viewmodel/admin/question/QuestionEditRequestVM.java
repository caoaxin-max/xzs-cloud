package com.xyxy.kst.cax.viewmodel.admin.question;

import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/21/10:17
 */
@Data
public class QuestionEditRequestVM {

    // 题目id
    private Integer id;
    // 题目类型
    private Integer questionType;
    // 年级
    private Integer gradeLevel;
    // 学科id
    private Integer subjectId;
    // 题干
    private String title;
    // 选项或者其他
    private List<QuestionEditItemVM> items;
    // 解析
    private String analyze;
    // 正确答案
    private String correct;
    // 分数
    private Integer score;
    // 难度
    private Integer difficult;
    // 创建用户
    private String createUser;
    // 多选题答案
    private List<String> correctArray;
    // 排序
    private Integer itemOrder;

}

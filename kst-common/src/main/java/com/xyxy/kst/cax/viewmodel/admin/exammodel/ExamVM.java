package com.xyxy.kst.cax.viewmodel.admin.exammodel;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/17/19:20
 */
@Data
public class ExamVM {
    // 试卷id
    private Integer id;
    // 年级
    private Integer level;
    // 学科
    private Integer subjectId;
    // 当前页
    private Long pageIndex;
    // 一页显示多少条数据
    private Long pageSize;
    //试卷类型
    private Integer paperType;
    // 状态
    private Integer status;
    // 建议时间
    private Integer suggestTime;
    // 限制时间
    private List<String> limitDateTime;
    // 试卷标题
    private List<ExamPaperTitleItemVM> titleItems;
    // 试卷名称
    private String name;
    // 试卷总分
    private Integer score;
    // t_exam_paper_answer id
    private Integer examPaperAnswerId;
}

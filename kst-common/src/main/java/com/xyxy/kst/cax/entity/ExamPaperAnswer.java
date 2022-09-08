package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/17:41
 */
@Data
@TableName("t_exam_paper_answer")
public class ExamPaperAnswer  implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("exam_paper_id")
    private Integer examPaperId;

    /**
     * 试卷名称
     */
    @TableField("paper_name")
    private String paperName;

    /**
     * 试卷类型( 1固定试卷 4.时段试卷 6.任务试卷)
     */
    @TableField("paper_type")
    private Integer paperType;

    /**
     * 学科
     */
    @TableField("subject_id")
    private Integer subjectId;

    /**
     * 年级
     */
    @TableField("grade_level")
    private Integer gradeLevel;

    /**
     * 系统判定得分
     */
    @TableField("system_score")
    private Integer systemScore;

    /**
     * 最终得分(千分制)
     */
    @TableField("user_score")
    private Integer userScore;

    /**
     * 试卷总分
     */
    @TableField("paper_score")
    private Integer paperScore;

    /**
     * 做对题目数量
     */
    @TableField("question_correct")
    private Integer questionCorrect;

    /**
     * 题目总数量
     */
    @TableField("question_count")
    private Integer questionCount;

    /**
     * 做题时间(秒)
     */
    @TableField("do_time")
    private Integer doTime;

    /**
     * 试卷状态(1待判分 2完成)
     */
    @TableField("status")
    private Integer status;

    /**
     * 学生
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableField("task_exam_id")
    private Integer taskExamId;

    // 学科名称
    @TableField(exist = false)
    private String subjectName;
}

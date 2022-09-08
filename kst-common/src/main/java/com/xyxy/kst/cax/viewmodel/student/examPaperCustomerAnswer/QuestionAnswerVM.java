package com.xyxy.kst.cax.viewmodel.student.examPaperCustomerAnswer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xyxy.kst.cax.viewmodel.student.examPaperAnswer.PageVM;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/21/15:32
 */
@Data
public class QuestionAnswerVM extends PageVM {
    private Integer id;
    // 题干
    private String shortTitle;
    // 题型
    private Integer questionType;
    // 学科名称
    private String subjectName;
    // 做题时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}

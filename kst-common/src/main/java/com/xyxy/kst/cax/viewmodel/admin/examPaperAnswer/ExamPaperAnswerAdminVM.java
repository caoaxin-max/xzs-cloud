package com.xyxy.kst.cax.viewmodel.admin.examPaperAnswer;

import lombok.Data;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/6/9:51
 */
@Data
public class ExamPaperAnswerAdminVM {
   private Long pageIndex;
   private Long pageSize;
   private Integer subjectId;
   private Integer level;
   private Integer status;
   private String currentUser;
}

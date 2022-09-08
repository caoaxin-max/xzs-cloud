package com.xyxy.kst.cax.viewmodel.admin.task;

import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/22/19:54
 */
@Data
public class TaskExamVM {
    private Integer id;
    private Integer gradeLevel;
    private String title;
    private List<ExamVM> paperItems;
    private Long pageIndex;
    private Long pageSize;

}

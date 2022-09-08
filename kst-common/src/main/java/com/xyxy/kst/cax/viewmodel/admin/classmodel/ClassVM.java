package com.xyxy.kst.cax.viewmodel.admin.classmodel;

import com.xyxy.kst.cax.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/15:57
 */
@Data
public class ClassVM {

    private Integer id;
    private String className;
    private Integer level;
    private Long pageIndex;
    private Long pageSize;
    private String teacher;
}

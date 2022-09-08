package com.xyxy.kst.cax.viewmodel.admin.usermodel;

import com.xyxy.kst.cax.entity.User;
import lombok.Data;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/1/14:35
 */
@Data
public class PageAndSearch {

    private Long pageIndex;
    private Long pageSize;
    private Integer role;
    private String userName;
    private Integer userId;
    private Integer level;
    private String questionType;
    private Integer id;
    private Integer subjectId;
    private String currentUserName;
}

package com.xyxy.kst.cax.viewmodel.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/8/17:11
 */
@Data
public class UserVM {

    private String userName;
    private String realName;
    private Integer age;
    private Integer sex;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    private String phone;
    private Integer userLevel;
    private String className;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    private String imagePath;
    private String command;
}

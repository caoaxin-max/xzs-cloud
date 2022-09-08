package com.xyxy.kst.cax.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/17:45
 */
@TableName("t_user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("user_uuid")
    private String userUuid;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名", index = 0)
    @TableField("user_name")
    private String userName;

    @ExcelProperty(value = "密码", index = 1)
    @TableField("password")
    private String password;

    /**
     * 真实姓名
     */
    @ExcelProperty(value = "真实姓名", index = 2)
    @TableField("real_name")
    private String realName;

    @ExcelProperty(value = "年龄", index = 3)
    @TableField("age")
    private Integer age;

    /**
     * 1.男 2女
     */
    @ExcelProperty(value = "性别", index = 4)
    @TableField("sex")
    private Integer sex;

    @ExcelProperty(value = "生日", index = 5)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("birth_day")
    private Date birthDay;

    /**
     * 学生年级(1-12)
     */
    @ExcelProperty(value = "年级", index = 6)
    @TableField("user_level")
    private Integer userLevel;

    @ExcelProperty(value = "手机号", index = 7)
    @TableField("phone")
    private String phone;

    /**
     * 1.学生 2.老师 3.管理员
     */
    @TableField("role")
    private Integer role;

    /**
     * 1.启用 2禁用
     */
    @TableField("status")
    private Integer status;

    /**
     * 头像地址
     */
    @TableField("image_path")
    private String imagePath;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("modify_time")
    private Date modifyTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("last_active_time")
    private Date lastActiveTime;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField("deleted")
    private Boolean deleted;

    @TableField("class_id")
    private Integer classId;

    @TableField(exist = false)
    private Class clazz;

    @TableField(exist = false)
    private String className;
    /**
     * 微信openId
     */
    @TableField("wx_open_id")
    private String wxOpenId;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userUuid='" + userUuid + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthDay=" + birthDay +
                ", userLevel=" + userLevel +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", lastActiveTime=" + lastActiveTime +
                ", deleted=" + deleted +
                ", classId=" + classId +
                ", clazz=" + clazz +
                ", className='" + className + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                '}';
    }
}

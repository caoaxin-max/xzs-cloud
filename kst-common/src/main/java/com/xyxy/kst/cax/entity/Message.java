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
 * @Date 2022/5/24/17:42
 */
@Data
@TableName("t_message")
public class Message  implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    /**
     * 发送者用户ID
     */
    @TableField("send_user_id")
    private Integer sendUserId;

    /**
     * 发送者用户名
     */
    @TableField("send_user_name")
    private String sendUserName;

    /**
     * 发送者真实姓名
     */
    @TableField("send_real_name")
    private String sendRealName;

    /**
     * 接收人数
     */
    @TableField("receive_user_count")
    private Integer receiveUserCount;

    /**
     * 已读人数
     */
    @TableField("read_count")
    private Integer readCount;
}

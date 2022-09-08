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
 * @Date 2022/5/24/17:43
 */
@Data
@TableName("t_message_user")
public class MessageUser  implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 消息内容ID
     */
    @TableField("message_id")
    private Integer messageId;

    /**
     * 接收人ID
     */
    @TableField("receive_user_id")
    private Integer receiveUserId;

    /**
     * 接收人用户名
     */
    @TableField("receive_user_name")
    private String receiveUserName;

    /**
     * 接收人真实姓名
     */
    @TableField("receive_real_name")
    private String receiveRealName;

    /**
     * 是否已读
     */
    @TableField("readed")
    private Boolean readed;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    /**
     * 阅读时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("read_time")
    private Date readTime;

}

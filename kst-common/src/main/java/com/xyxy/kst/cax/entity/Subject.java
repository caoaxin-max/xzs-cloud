package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/17:43
 */
@TableName("t_subject")
public class Subject  implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 语文 数学 英语 等
     */
    @TableField("name")
    private String name;

    /**
     * 年级 (1-12) 小学 初中
     */
    @TableField("level")
    private Integer level;

    /**
     * 一年级、二年级等
     */
    @TableField("level_name")
    private String levelName;

    /**
     * 排序
     */
    @TableField("item_order")
    private Integer itemOrder;

    @TableLogic
    @TableField("deleted")
    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

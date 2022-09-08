package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/16/10:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_menu")
public class Menu implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer menuId;

    /**
     * 父节点id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 前端组件所在的位置
     */
    @TableField("component")
    private String component;

    /**
     * 菜单在前端的路由
     */
    @TableField("url")
    private String url;

    /**
     * 前端组件名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否隐藏组件
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 是否有缓存(0.为false有缓存，1 为true无缓存)
     */
    @TableField("no_cache")
    private Boolean noCache;

    /**
     * 活跃在的菜单
     */
    @TableField("active_menu")
    private String activeMenu;

    @TableField(exist = false)
    private List<Menu> menus;
}

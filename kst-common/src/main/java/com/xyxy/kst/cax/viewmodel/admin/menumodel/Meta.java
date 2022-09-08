package com.xyxy.kst.cax.viewmodel.admin.menumodel;

import lombok.Data;

/**
 * 前端meta
 * @Author 曹阿鑫
 * @Date 2022/8/18/11:24
 */
@Data
public class Meta {
    private String title;
    private String icon;
    private Boolean noCache;
    private String activeMenu;
}

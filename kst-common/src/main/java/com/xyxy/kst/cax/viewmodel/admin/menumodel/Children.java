package com.xyxy.kst.cax.viewmodel.admin.menumodel;

import lombok.Data;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/18/11:25
 */
@Data
public class Children {
    private String path;
    private String component;
    private String name;
    private Meta meta;
    private Boolean hidden;
}

package com.xyxy.kst.cax.viewmodel.admin.menumodel;

import lombok.Data;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/18/11:22
 */
@Data
public class MenuVM {
    private String path;
    private String component;
    private String name;
    private Meta meta;
    private List<Children> children;
}

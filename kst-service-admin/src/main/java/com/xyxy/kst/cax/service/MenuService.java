package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.Menu;
import com.xyxy.kst.cax.viewmodel.admin.menumodel.MenuVM;

import java.util.List;

public interface MenuService extends IService<Menu> {

    /**
     * 获取老师和管理员的菜单
     * @return
     */
    List<MenuVM> getMenu(Integer role);

}

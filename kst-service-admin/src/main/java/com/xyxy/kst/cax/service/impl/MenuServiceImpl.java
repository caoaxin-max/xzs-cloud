package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.MenuDao;
import com.xyxy.kst.cax.entity.Menu;
import com.xyxy.kst.cax.exception.NotPermissionException;
import com.xyxy.kst.cax.exception.NotRoleException;
import com.xyxy.kst.cax.service.MenuService;
import com.xyxy.kst.cax.viewmodel.admin.menumodel.Children;
import com.xyxy.kst.cax.viewmodel.admin.menumodel.MenuVM;
import com.xyxy.kst.cax.viewmodel.admin.menumodel.Meta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/16/19:08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {
    @Override
    public List<MenuVM> getMenu(Integer role) {
        if (role == 3){
            List<Menu> adminMenu = baseMapper.getAdminMenu();
            List<MenuVM> menuVMList = formatMenu(adminMenu);
            return menuVMList;
        }else if (role == 2){
            List<Menu> adminMenu = baseMapper.getTeacherMenu(role);
            List<MenuVM> menuVMList = formatMenu(adminMenu);
            return menuVMList;
        }
        throw new NotRoleException("没有权限访问！");
    }


    /**
     * 格式化传给前端的菜单信息
     * @param adminMenu
     * @return
     */
    public List<MenuVM> formatMenu(List<Menu> adminMenu){
        List<MenuVM> menuVMList = new ArrayList<>();
        for (Menu menu : adminMenu) {
            MenuVM menuVM = new MenuVM();
            menuVM.setPath(menu.getUrl());
            menuVM.setName(menu.getName());
            menuVM.setComponent(menu.getComponent());
            Meta meta = new Meta();
            meta.setTitle(menu.getMenuName());
            meta.setIcon(menu.getIcon());
            meta.setNoCache(menu.getNoCache());
            menuVM.setMeta(meta);
            List<Children> childrenList = new ArrayList<>();
            for (Menu menuChild : menu.getMenus()) {
                Children children = new Children();
                children.setPath(menuChild.getUrl());
                children.setComponent(menuChild.getComponent());
                children.setName(menuChild.getName());
                children.setHidden(menuChild.getHidden());
                Meta metaChildren = new Meta();
                metaChildren.setTitle(menuChild.getMenuName());
                metaChildren.setNoCache(menuChild.getNoCache());
                metaChildren.setActiveMenu(menuChild.getActiveMenu());
                children.setMeta(metaChildren);
                childrenList.add(children);
            }
            menuVM.setChildren(childrenList);
            menuVMList.add(menuVM);
        }
        return menuVMList;
    }
}

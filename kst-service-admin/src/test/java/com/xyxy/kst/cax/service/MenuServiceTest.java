package com.xyxy.kst.cax.service;

import com.xyxy.kst.cax.dao.MenuDao;
import com.xyxy.kst.cax.entity.Menu;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.menumodel.MenuVM;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/18/14:32
 */
@SpringBootTest
public class MenuServiceTest {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuService menuService;
    @Test
    public void test(){
        List<MenuVM> menu = menuService.getMenu(2);
        String s = JsonUtil.toJsonStr(menu);
        System.out.println(s);
    }

    @Test
    private void test01(){
        List<MenuVM> menu = menuService.getMenu(3);
        String s = JsonUtil.toJsonStr(menu);
        System.out.println(s);
    }
}

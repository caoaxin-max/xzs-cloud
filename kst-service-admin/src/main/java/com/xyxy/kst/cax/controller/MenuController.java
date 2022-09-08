package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.MenuService;
import com.xyxy.kst.cax.viewmodel.admin.menumodel.MenuVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/18/11:32
 */
@RestController
@RequestMapping("/api/admin")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/getMenu/{role}")
    public Result getMenu(@PathVariable("role") Integer role){
        List<MenuVM> list = menuService.getMenu(role);
        return Result.ok(list);
    }
}

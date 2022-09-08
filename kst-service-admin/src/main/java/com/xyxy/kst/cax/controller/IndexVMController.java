package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.IndexVMService;
import com.xyxy.kst.cax.viewmodel.admin.dashboard.IndexVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/20:26
 */

@RestController
@RequestMapping("/api/admin")
public class IndexVMController {

    @Autowired
    private IndexVMService indexVMService;

    /**
     * 获取前端index所需要的所有数据
     */
    @PostMapping("/index")
    public Result getIndexVM(){
        IndexVM indexVM = indexVMService.getIndexVM();
        return Result.ok(indexVM);
    }
}

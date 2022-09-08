package com.xyxy.kst.cax.controller;

import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.ClassService;
import com.xyxy.kst.cax.service.ClassTeacherService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.viewmodel.admin.classmodel.ClassVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/16:07
 */
@RestController
@RequestMapping("/api/admin")
public class ClassController {
    @Autowired
    private ClassService classService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClassTeacherService classTeacherService;

    /**
     * 分页条件查询，条件是班级名称或者年级
     * @param classVM
     * @return
     */
    @PostMapping("/class/page")
    public Result classPageList(@RequestBody ClassVM classVM){
        Map<String, Object> map = classService.classPageList(classVM);
        return Result.ok(map);
    }

    /**
     * 创建或者修改班级信息
     * @param classVM
     * @return
     */
    @PostMapping("/class/edit")
    public Result createOrUpdateClass(@RequestBody ClassVM classVM){
        Result result = classService.createOrUpdateClass(classVM);
        return result;
    }


    /**
     * 删除班级
     * @param id
     * @return
     */
    @PostMapping("/class/delete/{id}")
    public Result deleteClass(@PathVariable Integer id){
        classService.deleteClass(id);
        return Result.build(200, "删除班级成功");
    }

    @PostMapping("/class/select/{id}")
    public Result selectClass(@PathVariable Integer id) {
        Class aclass = classService.selectClass(id);
        Map<String, Object> map = new HashMap<>();
        ClassTeacher classTeacher = classTeacherService.selectClassTeacher(aclass.getId());
        User user = userService.selectById(classTeacher.getTeacherId());
        map.put("id", aclass.getId());
        map.put("level", aclass.getLevel());
        map.put("className", aclass.getClassName());
        map.put("teacher", user.getUserName());
        return Result.ok(map);
    }
}

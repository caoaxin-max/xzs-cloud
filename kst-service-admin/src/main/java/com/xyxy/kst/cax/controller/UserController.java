package com.xyxy.kst.cax.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.remote.admin.RemoteExamPaperAnalyse;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.ClassService;
import com.xyxy.kst.cax.service.ClassTeacherService;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;

import com.xyxy.kst.cax.viewmodel.student.AnalyseFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/26/13:52
 */
@RestController
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClassTeacherService classTeacherService;

    @Autowired
    private ClassService classService;

    @Autowired
    private RemoteExamPaperAnalyse remoteExamPaperAnalyse;

    // 根据用户名称获取用户信息
    @GetMapping("/getUserByUserName/{username}")
    public User getUserByUserName(@PathVariable("username") String username){
        User user = userService.getUserByUserName(username);
        return user;
    }

    @PostMapping("/user/page/list")
    public Result selectUserPageList(@RequestBody PageAndSearch pageAndSearch){
        User user = userService.getUserByUserName(pageAndSearch.getCurrentUserName());
        if (user.getRole() == 3){
            Page<User> page = new Page<>(pageAndSearch.getPageIndex(), pageAndSearch.getPageSize());
            IPage<User> userIPage = userService.selectUserPageByUsernameAndRole(page, pageAndSearch.getUserName(), pageAndSearch.getRole());
            List<User> users = userIPage.getRecords();
            for (User student: users) {
                Class clazz = classService.getById(student.getClassId());
                if (clazz == null){
                    continue;
                }else {
                    student.setClassName(clazz.getClassName());
                }
            }
            long total = userIPage.getTotal();
            long pageNum = userIPage.getCurrent();
            Map<String, Object> map = new HashMap<>();
            map.put("list", users);
            map.put("total", total);
            map.put("pageNum", pageNum);
            return Result.ok(map);
        }else {
            List<ClassTeacher> classTeachers = classTeacherService.selectClassTeacherByTeacherId(user.getId());
            List<Integer> collect = classTeachers.stream().map(ClassTeacher::getClassId).collect(Collectors.toList());
            List<Class> classes = classService.getClassByIdList(collect);
            List<Integer> classIdList = classes.stream().map(Class::getId).collect(Collectors.toList());
            Page<User> page = new Page<>(pageAndSearch.getPageIndex(), pageAndSearch.getPageSize());
            IPage<User> userIPage = userService.selectUserPageByUsernameAndRoleAndClass(page, pageAndSearch.getUserName(), pageAndSearch.getRole(), classIdList);
            List<User> list = userIPage.getRecords();
            for (User student: list) {
                Class clazz = classService.getById(student.getClassId());
                student.setClassName(clazz.getClassName());
            }
            long total = userIPage.getTotal();
            long pageNum = userIPage.getCurrent();
            Map<String, Object> map = new HashMap<>();
            map.put("list", list);
            map.put("total", total);
            map.put("pageNum", pageNum);
            return Result.ok(map);
        }
    }

    @PostMapping("/user/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return Result.build(200,"删除成功！");
    }

    @PostMapping("/user/changeStatus/{id}")
    public Result changeStatus(@PathVariable Integer id){
        System.out.println("============"+id);
        Integer status = userService.changeStatus(id);
        return Result.ok(status);
    }


    @PostMapping("/user/select/{id}")
    public Result selectUser(@PathVariable Integer id){
        User user = userService.selectById(id);
        return Result.ok(user);
    }

    @PostMapping("/user/edit")
    public Result createOrUpdateUser(@RequestBody User user){
        String message = userService.createOrUpdateUser(user);
        return Result.build(200,message);
    }

    @PostMapping("/user/current")
    public Result selectCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        User user = userService.getUserByUserName(loginUser.getUsername());
        return Result.ok(user);
    }

    @PostMapping("/exam/paper/analyse")
    public Result getAnalyseByStudent(@RequestBody AnalyseFrom analyseFrom){
        Result analyse = remoteExamPaperAnalyse.getAnalyse(analyseFrom);
        return analyse;
    }

    /**
     * 验证用户名唯一性
     * @param userName
     * @return
     */
    @PostMapping("/unique/{userName}")
    public Result checkUnique(@PathVariable("userName") String userName){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = userService.getUserByUserName(userName);
        if (user == null){
            return Result.ok();
        }else {
            return Result.build(506, "已存在该用户名，请更换");
        }
    }
}

package com.xyxy.kst.cax.student.controller;

import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.student.service.UserService;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.utils.UUID;
import com.xyxy.kst.cax.viewmodel.student.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/7/20:31
 */
@RestController
@RequestMapping("/api/student")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/user/current")
    public Result getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        User user = userService.getUserByUserName(loginUser.getUsername());
        if (user.getClassId() == 0){
            return Result.ok(user);
        }else {
            User user1 = userService.selectUserAndClass(user);
            String toJsonStr = JsonUtil.toJsonStr(user1);
            UserVM userVM = JsonUtil.toJsonObject(toJsonStr, UserVM.class);
            System.out.println(userVM.toString());
            userVM.setClassName(user1.getClazz().getClassName());
            return Result.ok(userVM);
        }
    }

    @PostMapping("/upload/image")
    public Result updateImageUrl(@RequestParam("file") MultipartFile multipartFile){
        final String imgPath = "E:\\毕业设计\\xzs-cloud\\kst-student\\src\\main\\resources\\updateImages";
        // 获取文件后缀名
        String fileName = multipartFile.getOriginalFilename();
//        System.out.println(fileName);
        String stffixName = fileName.substring(fileName.lastIndexOf("."));
        // 重命名文件
        UUID uuid = UUID.fastUUID();
        String finalName = uuid + stffixName;
        // 当文件名重复 可能性极小
        while( new File(finalName).exists()){
            uuid = UUID.fastUUID();
            finalName = uuid + stffixName;
        }
        // 文件保存
        String finalPath = imgPath + File.separator + finalName;
        try {
            multipartFile.transferTo(new File(finalPath));
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            LoginUser loginUser = tokenService.getLoginUser(request);
            User user = userService.getUserByUserName(loginUser.getUsername());
            String accordingUrl = "http://localhost:81/updateImages/"+finalName;
            if (user != null){
//                System.out.println(accordingUrl);
                user.setImagePath(accordingUrl);
                userService.updateUser(user);
            }
            Map<String, Object> map = new HashMap<>();
            map.put("message", "上传成功");
            map.put("accordingUrl", accordingUrl);
            return Result.ok(map);
        } catch (IOException e) {
            return Result.build(202,"上传失败");
        }
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/user/update")
    public Result updateUserStudent(@RequestBody User user){
        String message = userService.updateUser(user);
        return Result.build(200, message);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/user/register")
    public Result userRegister(@RequestBody User user) {
        Result result = userService.createUser(user);
        return result;
    }

    /**
     * 加入班级
     * @param userVM
     * @return
     */
    @PostMapping("/add/class")
    public Result addClass(@RequestBody UserVM userVM){
        System.out.println(userVM);
        Result result = userService.addClass(userVM);
        return result;
    }

}

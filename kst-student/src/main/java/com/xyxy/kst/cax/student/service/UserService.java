package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.viewmodel.student.UserVM;

public interface UserService extends IService<User> {
    /**
     * 获取用户名
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 更新用户
     * @param user1
     */
    String updateUser(User user1);

    /**
     * 创建用户
     * @param user
     * @return
     */
    Result createUser(User user);

    /**
     * 查询用户信息以及其所在班级
     * @param user
     * @return
     */
    User selectUserAndClass(User user);

    /**
     * 加入班级
     * @param userVM
     * @return
     */
    Result addClass(UserVM userVM);
}

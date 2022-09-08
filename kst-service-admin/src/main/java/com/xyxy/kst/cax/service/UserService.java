package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends IService<User> {

    // 根据用户名称获取用户信息
    User getUserByUserName(String username);

    // 分页查询学生、老师、管理员列表
    IPage<User> selectUserPageByUsernameAndRole(Page<User> page, String username, Integer role);

    // 删除用户
    void deleteUser(Integer id);

    // 更新状态
    Integer changeStatus(Integer id);

    // 更加id查询用户
    User selectById(Integer id);

    // 创建或者更新用户
    String createOrUpdateUser(User user);

    /**
     * 更新user的class_id为null
     * @param user
     */
    void updateUser(User user);

    /**
     * 获取该老师班级的学生
     * @param page
     * @param userName
     * @param role
     * @param classIdList
     * @return
     */
    IPage<User> selectUserPageByUsernameAndRoleAndClass(Page<User> page, String userName, Integer role, List<Integer> classIdList);
}

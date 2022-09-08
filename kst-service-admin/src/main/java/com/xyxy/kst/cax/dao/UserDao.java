package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/26/13:49
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 根据角色和用户名查询
     * @param username
     * @param role
     * @return
     */
    IPage<User> selectUserPageByUsernameAndRole(Page<?> page, @Param("username") String username, @Param("role") Integer role);

    /**
     * 更新user的class_id为null
     * @param user
     */
    void updateUser(@Param("user") User user);

    IPage<User> selectUserPageByUsernameAndRoleAndClass(Page<User> page, @Param("userName") String userName, @Param("role") Integer role, @Param("classIdList") List<Integer> classIdList);
}

package com.xyxy.kst.cax.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyxy.kst.cax.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 查询用户信息以及其所在班级
     * @param user
     * @return
     */
    User selectUserAndClass(@Param("user") User user);
}

package com.xyxy.kst.cax.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyxy.kst.cax.entity.UserEventLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserEventLogDao extends BaseMapper<UserEventLog> {

    /**
     * 查询今天的日志
     * @param username
     * @return
     */
    List<UserEventLog> selectUserEventDay(String username);
}

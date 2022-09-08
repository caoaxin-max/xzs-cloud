package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.entity.other.KeyValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserEventLogDao extends BaseMapper<UserEventLog> {

    /**
     * 查询这一个月用户每天的活跃度
     * @param startTime
     * @param endTime
     * @return
     */
    List<KeyValue> oneMonthUserActive (@Param("startTime")Date startTime, @Param("endTime") Date endTime);

    /**
     * 日志的分页模糊查询
     * @param page
     * @param userId
     * @param userName
     * @return IPage<UserEventLog>
     */
    IPage<UserEventLog> getUserEventPageList(Page<?> page, @Param("userId") Integer userId, @Param("userName") String userName);
}

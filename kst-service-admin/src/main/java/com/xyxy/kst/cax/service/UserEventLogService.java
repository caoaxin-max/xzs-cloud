package com.xyxy.kst.cax.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.entity.other.KeyValue;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserEventLogService extends IService<UserEventLog> {

    /**
     * 保存日志
     * @param userEventLog
     */
    void saveUserEventLog(UserEventLog userEventLog);

    /**
     * 查询这一个月用户每天的活跃度
     * @return
     */
    List<Integer> oneMonthUserActive ();

    /**
     * 分页模糊查询用户日志
     * @param pageAndSearch
     * @return
     */
    Map<String, Object> getUserEventPage(PageAndSearch pageAndSearch);
}

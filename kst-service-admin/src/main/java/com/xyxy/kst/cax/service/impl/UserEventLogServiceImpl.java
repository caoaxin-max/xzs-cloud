package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.UserEventLogDao;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.entity.other.KeyValue;
import com.xyxy.kst.cax.exception.BusinessException;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.UserEventLogService;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/26/14:30
 */
@Service
public class UserEventLogServiceImpl extends ServiceImpl<UserEventLogDao, UserEventLog> implements UserEventLogService {

    /**
     * 保存日志
     *
     * @param userEventLog
     */
    @Override
    public void saveUserEventLog(UserEventLog userEventLog) {
        if (userEventLog != null) {
            baseMapper.insert(userEventLog);
        } else {
            throw new BusinessException(503, "日志添加失败");
        }
    }

    /**
     * 查询这一个月用户每天的活跃度
     * @return
     */
    @Override
    public List<Integer> oneMonthUserActive() {
        Date startTime = DateTimeUtil.getMonthStartDay();
        Date endTime = DateTimeUtil.getMonthEndDay();
        List<KeyValue> oneMonthUserActiveCount = baseMapper.oneMonthUserActive(startTime, endTime);
        List<String> mothStartToNowFormat = DateTimeUtil.MothStartToNowFormat();
        return mothStartToNowFormat.stream().map(md -> {
            KeyValue keyValue = oneMonthUserActiveCount.stream()
                    .filter(kv -> kv.getName().equals(md)).findAny().orElse(null);
            return null == keyValue ? 0 : keyValue.getValue();
        }).collect(Collectors.toList());
    }


    @Override
    public Map<String, Object> getUserEventPage(PageAndSearch pageAndSearch) {
        Page<UserEventLog> page = new Page<>(pageAndSearch.getPageIndex(), pageAndSearch.getPageSize());
        IPage<UserEventLog> userEventPage = baseMapper.getUserEventPageList(page, pageAndSearch.getUserId(), pageAndSearch.getUserName());
        List<UserEventLog> records = userEventPage.getRecords();
        long total = userEventPage.getTotal();
        long pageNum = userEventPage.getCurrent();
        Map<String, Object> map = new HashMap<>();
        map.put("list", records);
        map.put("total", total);
        map.put("pageNum", pageNum);
        return map;
    }
}

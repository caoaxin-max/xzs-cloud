package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyxy.kst.cax.entity.EPQCustomerAnswer;
import com.xyxy.kst.cax.entity.other.KeyValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperQuestionCustomerAnswerDao extends BaseMapper<EPQCustomerAnswer> {

    /**
     * 查询某个时间段的题目作答数量
     * @param startTime
     * @param endTime
     * @return
     */
    List<KeyValue> selectCountByDate(@Param("startTime")Date startTime, @Param("endTime")Date endTime);
}

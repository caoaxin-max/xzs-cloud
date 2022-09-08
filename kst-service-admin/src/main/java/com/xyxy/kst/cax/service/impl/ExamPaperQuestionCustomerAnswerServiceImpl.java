package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ExamPaperQuestionCustomerAnswerDao;
import com.xyxy.kst.cax.entity.EPQCustomerAnswer;
import com.xyxy.kst.cax.entity.other.KeyValue;
import com.xyxy.kst.cax.service.ExamPaperQuestionCustomerAnswerService;
import com.xyxy.kst.cax.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/25/17:10
 */
@Service
public class ExamPaperQuestionCustomerAnswerServiceImpl extends ServiceImpl<ExamPaperQuestionCustomerAnswerDao, EPQCustomerAnswer> implements ExamPaperQuestionCustomerAnswerService
{

    /**
     * 获取累计做题的题目数
     * @return Integer ePQCustomerAnswerCount
     */
    @Override
    public Integer getEPQCustomerAnswerCount() {
        QueryWrapper<EPQCustomerAnswer> wrapper = new QueryWrapper<>();
        Integer ePQCustomerAnswerCount = baseMapper.selectCount(wrapper);
        return ePQCustomerAnswerCount;
    }

    /**
     * 查询某个时间段的题目作答数量
     * @return
     */
    @Override
    public List<Integer> selectCountByDate() {
        Date startTime = DateTimeUtil.getMonthStartDay();
        Date endTime = DateTimeUtil.getMonthEndDay();
        List<KeyValue> selectQuestionCountByDate = baseMapper.selectCountByDate(startTime, endTime);
        List<String> mothStartToNowFormat = DateTimeUtil.MothStartToNowFormat();
        return mothStartToNowFormat.stream().map(md -> {
            KeyValue keyValue = selectQuestionCountByDate.stream()
                    .filter(kv -> kv.getName().equals(md)).findAny().orElse(null);
            return null == keyValue ? 0 : keyValue.getValue();
        }).collect(Collectors.toList());
    }
}

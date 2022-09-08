package com.xyxy.kst.cax.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyxy.kst.cax.entity.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDao extends BaseMapper<Question> {
}

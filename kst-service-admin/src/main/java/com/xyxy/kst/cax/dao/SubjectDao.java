package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubjectDao extends BaseMapper<Subject> {

    /**
     * 获取学科列表并且有查询
     * @param page
     * @param level
     * @return
     */
    IPage<Subject> getSubjectPageList(@Param("page") Page<Subject> page,@Param("level") Integer level);
}

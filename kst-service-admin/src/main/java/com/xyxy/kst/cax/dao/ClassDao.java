package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.viewmodel.admin.classmodel.ClassVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassDao extends BaseMapper<Class> {

    /**
     * 分页条件查询，条件是班级名称或者年级
     * @param page
     * @param classVM
     * @return
     */
    IPage<Class> classPageList(Page<Class> page, @Param("classVM") ClassVM classVM);
}

package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/20:32
 */
@Mapper
public interface ExamPaperDao extends BaseMapper<ExamPaper> {

    /**
     * 分页条件查询
     * @param page
     * @param examVM
     * @return
     */
    IPage<ExamPaper> getExamPaperPage(@Param("page")Page<ExamPaper> page, @Param("examVM") ExamVM examVM);


    IPage<ExamPaper> taskExamPage(Page<ExamPaper> page, @Param("examVM") ExamVM examVM);
}

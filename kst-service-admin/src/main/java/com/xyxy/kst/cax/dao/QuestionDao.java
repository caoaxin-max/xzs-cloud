package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.Question;
import com.xyxy.kst.cax.viewmodel.admin.usermodel.PageAndSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionDao extends BaseMapper<Question> {

    /**
     * 分页条件查询
     * @param page
     * @return
     */
    IPage<Question> getQuestionPage(@Param("page") Page<Question> page, @Param("pageAndSearch") PageAndSearch pageAndSearch);

    List<Question> getQuestionGA(@Param("difficulty") int difficulty,
                                 @Param("subject") int subject,
                                 @Param("grade") int grade);
}

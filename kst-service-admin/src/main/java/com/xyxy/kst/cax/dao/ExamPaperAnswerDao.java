package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyxy.kst.cax.entity.ExamPaperAnswer;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.viewmodel.admin.examPaperAnswer.ExamPaperAnswerAdminVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamPaperAnswerDao extends BaseMapper<ExamPaperAnswer> {

    /**
     * 查询这一个月所作的所有试卷
     * @return
     */
    List<ExamPaperAnswer> oneMonthDoExamQuestion();


    /**
     * 分页条件查询
     * @param examPaperAnswerAdminVM
     * @return
     */
    IPage<ExamPaperAnswer> examPaperAnswerPage(Page page,@Param("examPaperAnswerAdminVM") ExamPaperAnswerAdminVM examPaperAnswerAdminVM);

    /**
     * 通过学生username查询该学生做的试卷
     * @param page
     * @param examPaperAnswerAdminVM
     * @param users
     * @return
     */
    IPage<ExamPaperAnswer> examPaperAnswerByStudentPage(Page<ExamPaperAnswer> page, @Param("examPaperAnswerAdminVM") ExamPaperAnswerAdminVM examPaperAnswerAdminVM, @Param("users") List<User> users);
}

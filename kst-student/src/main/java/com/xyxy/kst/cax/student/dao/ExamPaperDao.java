package com.xyxy.kst.cax.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyxy.kst.cax.entity.ExamPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamPaperDao extends BaseMapper<ExamPaper> {
    /**
     * 获取固定试卷
     * 要该班级老师创建的
     * @param userName
     * @return
     */
    List<ExamPaper> getFixedExamPaper(@Param("userName") String userName, @Param("level")Integer level);

    /**
     * 获取时段试卷
     * @param userName
     * @param level
     * @return
     */
    List<ExamPaper> selectTimeLimitPaper(@Param("userName") String userName, @Param("level")Integer level);

}

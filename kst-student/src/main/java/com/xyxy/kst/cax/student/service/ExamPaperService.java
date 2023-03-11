package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ExamPaper;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.viewmodel.admin.exammodel.ExamVM;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ExamPaperService extends IService<ExamPaper> {

    /**
     * 查询固定试卷和时段试卷
     * @return
     */
    Result selectExamPaper(Integer userId);


    /**
     * 分页条件查询
     * @param examVM
     * @return
     */
    Map<String, Object> selectExamPaperPage(ExamVM examVM);

    Map<String, List<Integer>> getAnalyseData(Date dateMonth);
}

package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.Subject;

import java.util.List;

public interface SubjectService extends IService<Subject> {

    /**
     * 查询学科列表
     * @return
     */
    List<Subject> getSubjectList();

}

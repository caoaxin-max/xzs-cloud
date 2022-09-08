package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ClassStudent;

import java.util.List;

public interface ClassStudentService extends IService<ClassStudent> {

    Integer selectCountStudent(Integer classId);

    /**
     * 查询班级中的学生id
     * @param id
     * @return
     */
    List<ClassStudent> selectStudent(Integer id);

    /**
     * 以classId删除ClassStudent
     * @param id
     */
    void deleteClassStudent(Integer id);
}

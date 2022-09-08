package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ClassTeacher;

import java.util.List;

public interface ClassTeacherService extends IService<ClassTeacher> {

    /**
     * 根据班级id获取该班级的老师
     * @param classId
     * @return
     */
    List<ClassTeacher> getClassTeacher(Integer classId);
}

package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.ClassTeacher;

import java.util.List;

public interface ClassTeacherService extends IService<ClassTeacher> {

    void saveClassTeacher(ClassTeacher classTeacher);

    /**
     * 根据classId查询信息
     * @param id
     * @return
     */
    ClassTeacher selectClassTeacher(Integer id);

    /**
     * 通过老师id查询班级
     * @param id
     * @return
     */
    List<ClassTeacher> selectClassTeacherByTeacherId(Integer id);
}

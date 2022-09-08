package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.student.dao.ClassTeacherDao;
import com.xyxy.kst.cax.student.service.ClassTeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/20/13:43
 */
@Service
public class ClassTeacherServiceImpl extends ServiceImpl<ClassTeacherDao, ClassTeacher> implements ClassTeacherService {
    @Override
    public List<ClassTeacher> getClassTeacher(Integer classId) {
        QueryWrapper<ClassTeacher> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id", classId);
        List<ClassTeacher> classTeachers = baseMapper.selectList(wrapper);
        return classTeachers;
    }
}

package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ClassTeacherDao;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.service.ClassTeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.WeakHashMap;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/17:55
 */
@Service
public class ClassTeacherServiceImpl extends ServiceImpl<ClassTeacherDao, ClassTeacher> implements ClassTeacherService {

    @Override
    public void saveClassTeacher(ClassTeacher classTeacher) {
        baseMapper.insert(classTeacher);
    }

    @Override
    public ClassTeacher selectClassTeacher(Integer id) {
        QueryWrapper<ClassTeacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id", id);
        ClassTeacher classTeacher = baseMapper.selectOne(queryWrapper);
        return classTeacher;
    }

    @Override
    public List<ClassTeacher> selectClassTeacherByTeacherId(Integer id) {
        QueryWrapper<ClassTeacher> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", id);
        List<ClassTeacher> classTeachers = baseMapper.selectList(wrapper);
        return classTeachers;
    }
}

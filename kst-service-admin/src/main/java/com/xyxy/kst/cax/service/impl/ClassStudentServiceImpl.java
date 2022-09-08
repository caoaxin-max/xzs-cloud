package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ClassStudentDao;
import com.xyxy.kst.cax.entity.ClassStudent;
import com.xyxy.kst.cax.service.ClassStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/18:52
 */
@Service
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentDao, ClassStudent> implements ClassStudentService {
    @Override
    public Integer selectCountStudent(Integer classId) {
        QueryWrapper<ClassStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_id", classId);
        Integer count = baseMapper.selectCount(queryWrapper);
        return count;
    }

    /**
     * 查询班级中的学生id
     * @param id
     * @return
     */
    @Override
    public List<ClassStudent> selectStudent(Integer id) {
        QueryWrapper<ClassStudent> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id", id);
        List<ClassStudent> classStudents = baseMapper.selectList(wrapper);
        return classStudents;
    }

    /**
     * 以classId删除ClassStudent
     * @param id
     */
    @Override
    public void deleteClassStudent(Integer id) {
        QueryWrapper<ClassStudent> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id", id);
        baseMapper.delete(wrapper);
    }
}

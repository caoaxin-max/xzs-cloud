package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.entity.ClassStudent;
import com.xyxy.kst.cax.student.dao.StudentClassDao;
import com.xyxy.kst.cax.student.service.StudentClassService;
import org.springframework.stereotype.Service;

/**
 * @Author 曹阿鑫
 * @Date 2022/8/20/14:50
 */
@Service
public class StudentClassServiceImpl extends ServiceImpl<StudentClassDao, ClassStudent> implements StudentClassService {
}

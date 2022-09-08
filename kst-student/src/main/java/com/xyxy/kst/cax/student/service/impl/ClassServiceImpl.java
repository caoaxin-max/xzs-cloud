package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.student.dao.ClassDao;
import com.xyxy.kst.cax.student.service.ClassService;
import com.xyxy.kst.cax.viewmodel.student.UserVM;
import org.springframework.stereotype.Service;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/8/18:33
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, Class> implements ClassService {

    @Override
    public Class isExistClass(UserVM userVM) {
        QueryWrapper<Class> wrapper = new QueryWrapper<>();
        wrapper.eq("class_password", userVM.getCommand());
        wrapper.eq("level", userVM.getUserLevel());
        Class aClass = baseMapper.selectOne(wrapper);
        return aClass;
    }
}

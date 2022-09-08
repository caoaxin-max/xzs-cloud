package com.xyxy.kst.cax.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.viewmodel.student.UserVM;


public interface ClassService extends IService<Class> {

    /**
     * 判断该班级是否存在
     * @param userVM
     * @return
     */
    Class isExistClass(UserVM userVM);
}

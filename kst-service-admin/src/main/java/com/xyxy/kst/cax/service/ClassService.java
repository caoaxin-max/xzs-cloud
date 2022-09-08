package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.viewmodel.admin.classmodel.ClassVM;

import java.util.List;
import java.util.Map;

public interface ClassService extends IService<Class> {

    /**
     * 分页条件查询，条件是班级名称或者年级
     * @param classVM
     * @return
     */
    Map<String, Object> classPageList(ClassVM classVM);

    /**
     * 创建或者修改班级信息
     * @param classVM
     * @return
     */
    Result createOrUpdateClass(ClassVM classVM);

    /**
     * 删除班级
     * @param id
     */
    void deleteClass(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Class selectClass(Integer id);

    /**
     * 通过班级id列表查询班级
     * @return
     */
    List<Class> getClassByIdList(List<Integer> collect);

}

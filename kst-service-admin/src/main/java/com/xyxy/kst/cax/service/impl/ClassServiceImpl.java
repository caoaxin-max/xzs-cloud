package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.ClassDao;
import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.entity.ClassStudent;
import com.xyxy.kst.cax.entity.ClassTeacher;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.exception.YyghException;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.service.ClassService;
import com.xyxy.kst.cax.service.ClassStudentService;
import com.xyxy.kst.cax.service.ClassTeacherService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.utils.IdUtils;
import com.xyxy.kst.cax.utils.JsonUtil;
import com.xyxy.kst.cax.viewmodel.admin.classmodel.ClassVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/16:06
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, Class> implements ClassService {

    @Autowired
    private UserService userService;

    @Autowired
    private ClassTeacherService classTeacherService;

    @Autowired
    private ClassStudentService classStudentService;
    /**
     * 分页条件查询，条件是班级名称或者年级
     * @param classVM
     * @return
     */
    @Override
    public Map<String, Object> classPageList(ClassVM classVM) {
        Page<Class> page = new Page<>(classVM.getPageIndex(), classVM.getPageSize());
        IPage<Class> classIPage = baseMapper.classPageList(page, classVM);
        List<Class> list = classIPage.getRecords();
        long total = classIPage.getTotal();
        long pageNum = classIPage.getCurrent();
        Map<String, Object> map = new HashMap<>();
        for (Class aclss : list){
            Integer classId = aclss.getId();
            Integer countStudent = classStudentService.selectCountStudent(classId);
            aclss.setClassNumber(countStudent);
        }
        map.put("list", list);
        map.put("total", total);
        map.put("pageNum", pageNum);
        return map;
    }

    /**
     * 创建或者修改班级信息
     * @param classVM
     * @return
     */
    @Override
    public Result createOrUpdateClass(ClassVM classVM) {
        Class aclass = baseMapper.selectById(classVM.getId());
        if (aclass == null) {
            User user = userService.getUserByUserName(classVM.getTeacher());
            if (user == null || user.getUserLevel() != classVM.getLevel()) {
               return Result.build(201, "该老师不存在系统中/不在该年级");
            }else {
                QueryWrapper<Class> wrapper = new QueryWrapper<>();
                wrapper.eq("class_name", classVM.getClassName());
                wrapper.eq("level", classVM.getLevel());
                Class aclass2 = baseMapper.selectOne(wrapper);
                if (aclass2 != null) {
                    return Result.build(201, "该班级名称已经存在");
                }else {
                    String toJsonStr = JsonUtil.toJsonStr(classVM);
                    Class aclass1 = JsonUtil.toJsonObject(toJsonStr, Class.class);
                    aclass1.setClassPassword(IdUtils.fastUUID());
                    aclass1.setCreateTime(new Date());
                    baseMapper.insert(aclass1);
                    QueryWrapper<Class> wrapper1 = new QueryWrapper<>();
                    wrapper1.eq("class_password", aclass1.getClassPassword());
                    Class aclass3 = baseMapper.selectOne(wrapper1);
                    ClassTeacher classTeacher = new ClassTeacher();
                    classTeacher.setClassId(aclass3.getId());
                    classTeacher.setCreateTime(new Date());
                    classTeacher.setUpdateTime(new Date());
                    classTeacher.setTeacherId(user.getId());
                    classTeacherService.saveClassTeacher(classTeacher);
                    return Result.build(200, "创建班级成功");
                }
            }
        }else {
            User user = userService.getUserByUserName(classVM.getTeacher());
            if (user == null) {
                return Result.build(201, "该老师不存在系统中");
            }else {
                QueryWrapper<Class> wrapper = new QueryWrapper<>();
                wrapper.eq("class_name", classVM.getClassName());
                Class aclass2 = baseMapper.selectOne(wrapper);
                if (aclass2 != null) {
                    return Result.build(201, "该班级名称已经存在");
                }else {
                    aclass.setClassName(classVM.getClassName());
                    aclass.setLevel(classVM.getLevel());
                    ClassTeacher classTeacher = new ClassTeacher();
                    classTeacher.setTeacherId(user.getId());
                    classTeacher.setUpdateTime(new Date());
                    classTeacherService.updateById(classTeacher);
                    baseMapper.updateById(aclass);
                    return Result.build(200, "修改班级信息成功");
                }
            }
        }
    }

    @Override
    public void deleteClass(Integer id) {
        Class aclass = baseMapper.selectById(id);
        if (aclass != null){
            List<ClassStudent> classStudents = classStudentService.selectStudent(id);
            for (ClassStudent classStudent : classStudents){
                User user = userService.getById(classStudent.getStudentId());
                user.setClassId(0);
                userService.updateUser(user);
            }
            classStudentService.deleteClassStudent(id);
            ClassTeacher classTeacher = classTeacherService.selectClassTeacher(id);
            if (classTeacher != null){
                classTeacherService.removeById(classTeacher.getId());
            }
            baseMapper.deleteById(id);
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Class selectClass(Integer id) {
        Class aClass = baseMapper.selectById(id);
        return aClass;
    }

    @Override
    public List<Class> getClassByIdList(List<Integer> collect) {
        List<Class> classes = baseMapper.selectBatchIds(collect);
        return classes;
    }
}

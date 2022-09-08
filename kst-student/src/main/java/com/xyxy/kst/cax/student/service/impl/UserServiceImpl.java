package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xyxy.kst.cax.entity.Class;
import com.xyxy.kst.cax.entity.ClassStudent;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.result.Result;
import com.xyxy.kst.cax.student.dao.UserDao;
import com.xyxy.kst.cax.student.service.ClassService;
import com.xyxy.kst.cax.student.service.StudentClassService;
import com.xyxy.kst.cax.student.service.UserService;
import com.xyxy.kst.cax.utils.IdUtils;

import com.xyxy.kst.cax.viewmodel.student.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/7/17:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentClassService studentClassService;

    /**
     * 获取用户名
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        User user = baseMapper.selectOne(wrapper);
        return user;
    }

    /**
     * 更新或者创建用户
     * @param user
     */
    @Override
    public String updateUser(User user) {
        User user1 = getUserByUserName(user.getUserName());
        /*if (user1 == null) {
            String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodePassword);
            user.setCreateTime(new Date());
            user.setModifyTime(new Date());
            user.setLastActiveTime(new Date());
            user.setUserUuid(IdUtils.fastUUID());
            baseMapper.insert(user);
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setContent("用户"+user.getUserName()+"被创建了");
            userEventLog.setCreateTime(new Date());
            return "添加用户成功";
        }else */

        if(user1 != null){
            user1.setModifyTime(new Date());
            user1.setUserName(user.getUserName());
            user1.setRealName(user.getRealName());
            user1.setAge(user.getAge());
            user1.setSex(user.getSex());
            user1.setBirthDay(user.getBirthDay());
            user1.setPhone(user.getPhone());
            user1.setImagePath(user.getImagePath());
            baseMapper.updateById(user1);
            return "更新用户信息成功";
        }
        return "更新用户信息失败";
    }

    /**
     * 查询用户信息以及其所在班级
     * @param user
     * @return
     */
    @Override
    public User selectUserAndClass(User user) {
        User user1 = baseMapper.selectUserAndClass(user);
        return user1;
    }

    @Override
    public Result createUser(User user) {
        User user1 = getUserByUserName(user.getUserName());
        if (user1 == null){
            String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodePassword);
            user.setCreateTime(new Date());
            user.setModifyTime(new Date());
            user.setLastActiveTime(new Date());
            user.setUserUuid(IdUtils.fastUUID());
            baseMapper.insert(user);
            UserEventLog userEventLog = new UserEventLog();
            userEventLog.setUserId(user.getId());
            userEventLog.setUserName(user.getUserName());
            userEventLog.setRealName(user.getRealName());
            userEventLog.setContent("用户"+user.getUserName()+"被创建了");
            userEventLog.setCreateTime(new Date());
            return Result.build(200, "用户注册成功");
        }else {
            return Result.build(406,"该用户已经存在");
        }
    }

    /**
     * 加入班级
     * @param userVM
     * @return
     */
    @Transactional
    @Override
    public Result addClass(UserVM userVM) {
        // 判断是密钥是否正确
        Class aClass = classService.isExistClass(userVM);
        if (aClass != null){
            User user = getUserByUserName(userVM.getUserName());
            user.setClassId(aClass.getId());
            this.updateUser(user);
            ClassStudent classStudent = new ClassStudent();
            classStudent.setStudentId(user.getId());
            classStudent.setClassId(aClass.getId());
            classStudent.setUpdateTime(new Date());
            classStudent.setCreateTime(new Date());
            studentClassService.save(classStudent);
            return Result.build(200, "添加班级成功");
        }else {
            return Result.build(230, "添加班级失败，口令或者所加入班级的年级错误");
        }
    }
}

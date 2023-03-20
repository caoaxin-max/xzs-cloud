package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.UserDao;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.entity.UserEventLog;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.service.UserEventLogService;
import com.xyxy.kst.cax.service.UserService;
import com.xyxy.kst.cax.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/26/13:51
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Autowired
    private UserEventLogService userEventLogService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    

    // 根据用户名称获取用户信息
    @Override
    public User getUserByUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", username);
        User user = baseMapper.selectOne(wrapper);
        return user;
    }

    // 分页查询学生、老师、管理员列表
    @Override
    public IPage<User> selectUserPageByUsernameAndRole(Page<User> page, String username, Integer role) {
        IPage<User> userIPage = baseMapper.selectUserPageByUsernameAndRole(page, username, role);
        return userIPage;
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        baseMapper.deleteById(id);
    }

    /**
     * 更改状态
     * @param id
     */
    @Override
    public Integer changeStatus(Integer id) {
        User user = baseMapper.selectById(id);
        if (user != null) {
            if (user.getStatus() == 1) {
                user.setStatus(2);
            }else if (user.getStatus() == 2) {
                user.setStatus(1);
            }
            user.setModifyTime(new Date());
            baseMapper.updateById(user);
            return user.getStatus();
        }
        return null;
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User selectById(Integer id) {
        User user = baseMapper.selectById(id);
        return user;
    }

    /**
     * 增加或更改用户
     * @param user
     * @return
     */
    @Override
    public String createOrUpdateUser(User user) {
        User user1 = baseMapper.selectById(user.getId());
        if (user1 == null) {
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
        }else {
            user.setModifyTime(new Date());
            boolean matches = bCryptPasswordEncoder.matches(user.getPassword(), user1.getPassword());
            if (matches){
                UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
                userUpdateWrapper.eq("id", user.getId());
                userUpdateWrapper.set("user_name", user.getUserName());
                userUpdateWrapper.set("real_name", user.getRealName());
                userUpdateWrapper.set("age", user.getAge());
                userUpdateWrapper.set("sex", user.getSex());
                userUpdateWrapper.set("birth_day", user.getBirthDay());
                userUpdateWrapper.set("user_level", user.getUserLevel());
                userUpdateWrapper.set("phone", user.getPhone());
                userUpdateWrapper.set("status", user.getStatus());
                userUpdateWrapper.set("modify_time", user.getModifyTime());
                return "更新用户信息成功";
            }else {
                String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encodePassword);
                baseMapper.updateById(user);
                return "更新用户信息成功";
            }
        }
    }

    /**
     * 更新user的class_id为null
     * @param user
     */
    @Override
    public void updateUser(User user) {
        baseMapper.updateUser(user);
    }

    @Override
    public IPage<User> selectUserPageByUsernameAndRoleAndClass(Page<User> page, String userName, Integer role, List<Integer> classIdList) {
        return baseMapper.selectUserPageByUsernameAndRoleAndClass(page, userName, role, classIdList);
    }
}

package com.xyxy.kst.cax.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.domain.LoginUser;
import com.xyxy.kst.cax.entity.Subject;
import com.xyxy.kst.cax.entity.User;
import com.xyxy.kst.cax.service.TokenService;
import com.xyxy.kst.cax.student.dao.SubjectDao;
import com.xyxy.kst.cax.student.service.SubjectService;
import com.xyxy.kst.cax.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/7/20/14:50
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;
    /**
     * 查询学科列表
     * @return
     */
    @Override
    public List<Subject> getSubjectList() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginUser loginUser = tokenService.getLoginUser(request);
        User user = userService.getUserByUserName(loginUser.getUsername());
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("level", user.getUserLevel());
        List<Subject> subjects = baseMapper.selectList(wrapper);
        return subjects;
    }
}

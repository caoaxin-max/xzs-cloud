package com.xyxy.kst.cax.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyxy.kst.cax.dao.SubjectDao;
import com.xyxy.kst.cax.entity.Subject;
import com.xyxy.kst.cax.service.SubjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/17/15:34
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {

    /**
     * 分页条件查询
     * @param page
     * @param level
     * @return
     */
    @Override
    public IPage<Subject> getSubjectPageList(Page<Subject> page, Integer level) {
        return baseMapper.getSubjectPageList(page,level);
    }

    /**
     * 删除学科
     * @param id
     * @return
     */
    @Override
    public Integer deleteSubject(Integer id) {
        // 删除的条数
        int i = baseMapper.deleteById(id);
        return i;
    }

    /**
     * 更新或添加学科
     * @param subject
     */
    @Override
    public String createOrUpdateSubject(Subject subject) {
        Subject subject1 = baseMapper.selectById(subject.getId());
        if (subject1 != null) {
            baseMapper.updateById(subject);
            return "更新成功";
        }else {
            baseMapper.insert(subject);
            return "创建成功";
        }
    }

    /**
     * 根据id查询学科
     * @param id
     * @return
     */
    @Override
    public Subject selectByIdSubject(Integer id) {
        Subject subject = baseMapper.selectById(id);
        return subject;
    }

    /**
     * 查询所有的年级和学科
     * @return
     */
    @Override
    public List<Subject> getSubjectList() {
        List<Subject> subjects = baseMapper.selectList(null);
        return subjects;
    }
}

package com.xyxy.kst.cax.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyxy.kst.cax.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectService extends IService<Subject> {
    /**
     * 分页且按照年级查询
     * @param page
     * @param level
     * @return
     */
    IPage<Subject> getSubjectPageList(Page<Subject> page, Integer level);

    /**
     * 删除学科
     * @param id
     * @return
     */
    Integer deleteSubject(Integer id);

    /**
     * 更新或添加学科
     * @param subject
     */
    String createOrUpdateSubject(Subject subject);

    /**
     * 根据id查询学科
     * @param id
     * @return
     */
    Subject selectByIdSubject(Integer id);

    /**
     * 查询所有的年级和学科
     * @return
     */
    List<Subject> getSubjectList();

}

package com.xyxy.kst.cax.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyxy.kst.cax.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 获取admin的路由菜单
     * @return
     */
    List<Menu> getAdminMenu();

    /**
     * 获取教师端动态路由菜单
     * @param role
     * @return
     */
    List<Menu> getTeacherMenu(Integer role);

}

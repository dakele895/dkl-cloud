package com.dkl.server.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dkl.entity.system.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单表  Mapper 接口
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	/**
	 * 获取当前用户下的菜单列表
	 * @param username
	 * @return List<SysMenu>
	 */
	List<SysMenu> findUserPermissions(String username);


	/**
	 * 通过用户名查询菜单信息
	 *
	 * @param username 用户名
	 * @return 菜单信息
	 */
	List<SysMenu> findUserMenus(String username);
}

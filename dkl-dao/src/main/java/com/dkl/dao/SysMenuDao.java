package com.dkl.dao;


import com.dkl.entity.system.SysMenu;

import java.util.List;

/**
 * @author: dalele
 * @date: 2020/3/18 15:52
 * @description:
 */
public interface SysMenuDao extends BaseDao<SysMenu> {
	/**
	 * 获取当前用户下的菜单列表
	 * @param username
	 * @return List<SysMenu>
	 */
	List<SysMenu> findUserPermissions(String username);
}

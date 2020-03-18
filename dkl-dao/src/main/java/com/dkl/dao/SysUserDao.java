package com.dkl.dao;


import com.dkl.entity.system.SysUser;

/**
 * @author: dalele
 * @date: 2020/3/18 16:12
 * @description:
 */
public interface SysUserDao extends BaseDao<SysUser> {

	/**
	 * 通过用户名获取当前用户
	 * @param username
	 * @return SysUser
	 */
	SysUser findByName(String username);
}

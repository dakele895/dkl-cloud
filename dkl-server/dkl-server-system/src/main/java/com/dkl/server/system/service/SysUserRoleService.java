package com.dkl.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dkl.entity.system.SysUserRole;

/**
 * <p>
 * 用户和角色关联表  服务类
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
public interface SysUserRoleService extends IService<SysUserRole> {

	/**
	 *	通过角色删除关联
	 * @param roleIds
	 */
	void deleteUserRolesByRoleId(String[] roleIds);

	/**
	 * 通过用户删除关联
	 * @param userIds
	 */
	void deleteUserRolesByUserId(String[] userIds);

}

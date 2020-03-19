package com.dkl.server.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dkl.entity.QueryRequest;
import com.dkl.entity.system.SysUser;

/**
 * @author: dalele
 * @date: 2020/3/19 17:22
 * @description:
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 查找用户详细信息
	 *
	 * @param request request
	 * @param user    用户对象，用于传递查询条件
	 * @return IPage
	 */
	IPage<SysUser> findUserDetail(SysUser user, QueryRequest request);

	/**
	 * 新增用户
	 *
	 * @param user user
	 */
	void createUser(SysUser user);

	/**
	 * 修改用户
	 *
	 * @param user user
	 */
	void updateUser(SysUser user);

	/**
	 * 删除用户
	 *
	 * @param userIds 用户 id数组
	 */
	void deleteUsers(String[] userIds);
}

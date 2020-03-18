package com.dkl.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dkl.entity.QueryRequest;
import com.dkl.entity.system.SysUser;
import org.apache.ibatis.annotations.Param;

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

	/**
	 * 查找用户详细信息
	 *
	 * @param page 分页对象
	 * @param user 用户对象，用于传递查询条件
	 * @return Ipage
	 */
	IPage<SysUser> findUserDetailPage(Page page, @Param("user") SysUser user);

}

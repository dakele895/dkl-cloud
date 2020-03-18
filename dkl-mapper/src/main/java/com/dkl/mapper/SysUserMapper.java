package com.dkl.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dkl.entity.system.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 用户表 Mapper 接口
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

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

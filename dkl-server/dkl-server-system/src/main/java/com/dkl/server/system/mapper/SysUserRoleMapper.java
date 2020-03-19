package com.dkl.server.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dkl.entity.system.SysUserRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户和角色关联表  Mapper 接口
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

	/**
	 * 根据用户Id删除该用户的角色关系
	 *
	 * @param userId 用户 ID
	 * @return boolean
	 */
	Boolean deleteByUserId(@Param("userId") Long userId);

	/**
	 * 根据角色Id删除该角色的用户关系
	 *
	 * @param roleId 角色 ID
	 * @return boolean
	 */
	Boolean deleteByRoleId(@Param("roleId") Long roleId);

}

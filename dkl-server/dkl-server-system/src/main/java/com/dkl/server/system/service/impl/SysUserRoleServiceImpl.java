package com.dkl.server.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dkl.entity.system.SysUserRole;
import com.dkl.server.system.mapper.SysUserRoleMapper;
import com.dkl.server.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * <p>
 * 用户和角色关联表  服务实现类
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

	@Override
	@Transactional
	public void deleteUserRolesByRoleId(String[] roleIds) {
		Arrays.stream(roleIds).forEach(id -> baseMapper.deleteByRoleId(Long.valueOf(id)));
	}

	@Override
	@Transactional
	public void deleteUserRolesByUserId(String[] userIds) {
		Arrays.stream(userIds).forEach(id -> baseMapper.deleteByUserId(Long.valueOf(id)));
	}
}

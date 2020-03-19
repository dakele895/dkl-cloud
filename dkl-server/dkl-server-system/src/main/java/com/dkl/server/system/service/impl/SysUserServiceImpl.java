package com.dkl.server.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dkl.constant.DklConstant;
import com.dkl.entity.QueryRequest;
import com.dkl.entity.system.SysUser;
import com.dkl.entity.system.SysUserRole;
import com.dkl.server.system.mapper.SysUserMapper;
import com.dkl.server.system.service.SysUserRoleService;
import com.dkl.server.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author: dalele
 * @date: 2020/3/19 17:24
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	@Autowired
	private SysUserRoleService userRoleService;
	@Autowired
	private PasswordEncoder    passwordEncoder;

	@Override
	public IPage<SysUser> findUserDetail(SysUser user, QueryRequest request) {
		Page<SysUser> page = new Page<>(request.getPageNum(), request.getPageSize());
		return this.baseMapper.findUserDetailPage(page, user);
	}

	@Override
	@Transactional
	public void createUser(SysUser user) {
		// 创建用户
		user.setCreatedTime(new Date());
		user.setAvatar(DklConstant.DEFAULT_AVATAR);
		user.setPassword(passwordEncoder.encode(DklConstant.DEFAULT_PASSWORD));
		save(user);
		// 保存用户角色
		String[] roles = user.getRoleId().split(StringPool.COMMA);
		setUserRoles(user, roles);
	}

	@Override
	@Transactional
	public void updateUser(SysUser user) {
		// 更新用户
		user.setPassword(null);
		user.setUsername(null);
		user.setCreatedTime(null);
		user.setUpdatedTime(new Date());
		updateById(user);

		userRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, user.getUserId()));
		String[] roles = user.getRoleId().split(StringPool.COMMA);
		setUserRoles(user, roles);
	}

	@Override
	@Transactional
	public void deleteUsers(String[] userIds) {
		List<String> list = Arrays.asList(userIds);
		removeByIds(list);
		// 删除用户角色
		this.userRoleService.deleteUserRolesByUserId(userIds);
	}

	private void setUserRoles(SysUser user, String[] roles) {
		Arrays.stream(roles).forEach(roleId -> {
			SysUserRole ur = new SysUserRole();
			ur.setUserId(user.getUserId());
			ur.setRoleId(Long.valueOf(roleId));
			userRoleService.save(ur);
		});
	}
}

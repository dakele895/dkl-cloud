package com.dkl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dkl.dao.SysUserDao;
import com.dkl.entity.QueryRequest;
import com.dkl.entity.system.SysUser;
import com.dkl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: dalele
 * @date: 2020/3/19 02:52
 * @description:
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public IPage<SysUser> findUserDetail(SysUser user, QueryRequest request) {
		Page<SysUser> page = new Page<>(request.getPageNum(), request.getPageSize());
		return sysUserDao.findUserDetailPage(page, user);
	}

	@Override
	public void createUser(SysUser user) {

	}

	@Override
	public void updateUser(SysUser user) {

	}

	@Override
	public void deleteUsers(String[] userIds) {

	}

	@Override
	public SysUser getUser(Long id) {
		return sysUserDao.getById(id);
	}
}

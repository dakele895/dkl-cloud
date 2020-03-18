package com.dkl.dao.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dkl.dao.SysUserDao;
import com.dkl.entity.QueryRequest;
import com.dkl.entity.system.SysUser;
import com.dkl.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: dalele
 * @date: 2020/3/18 16:13
 * @description:
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUserMapper,SysUser> implements SysUserDao {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByName(String username) {
		return sysUserMapper.findByName(username);
	}

	@Override
	public IPage<SysUser> findUserDetailPage(Page page, SysUser user) {
		return sysUserMapper.findUserDetailPage(page,user);
	}


}

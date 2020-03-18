package com.dkl.dao.impl;


import com.dkl.dao.SysUserDao;
import com.dkl.entity.system.SysUser;
import com.dkl.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}

package com.dkl.dao.impl;

import com.dkl.dao.SysMenuDao;
import com.dkl.entity.system.SysMenu;
import com.dkl.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dalele
 * @date: 2020/3/18 15:53
 * @description:
 */
@Repository
public class SysMenuDaoImpl extends BaseDaoImpl<SysMenuMapper,SysMenu> implements SysMenuDao {

	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public List<SysMenu> findUserPermissions(String username) {
		return sysMenuMapper.findUserPermissions(username);
	}
}

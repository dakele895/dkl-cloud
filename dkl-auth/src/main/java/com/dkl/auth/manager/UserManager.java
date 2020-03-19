package com.dkl.auth.manager;


import com.dkl.auth.mapper.SysMenuMapper;
import com.dkl.auth.mapper.SysUserMapper;
import com.dkl.entity.system.SysMenu;
import com.dkl.entity.system.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: dalele
 * @date: 2020/3/19 00:39
 * @description:
 */
@Service
public class UserManager {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysMenuMapper sysMenuMapper;

	public SysUser findByName(String username) {
		return sysUserMapper.findByName(username);
	}

	public String findUserPermissions(String username) {
		List<SysMenu> userPermissions = sysMenuMapper.findUserPermissions(username);
		return userPermissions.stream().map(SysMenu::getPerms).collect(Collectors.joining(","));
	}
}

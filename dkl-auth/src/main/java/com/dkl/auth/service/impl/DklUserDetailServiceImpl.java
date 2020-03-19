package com.dkl.auth.service.impl;

import com.dkl.auth.DklAuthUser;
import com.dkl.auth.constant.AuthConstant;
import com.dkl.auth.manager.UserManager;
import com.dkl.auth.service.DklUserDetailService;
import com.dkl.entity.system.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 02:25
 * @Description:
 */
@Service
public class DklUserDetailServiceImpl implements DklUserDetailService {


	@Autowired
	private UserManager userManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = userManager.findByName(username);
		if (sysUser != null) {
			String permissions = userManager.findUserPermissions(sysUser.getUsername());
			boolean notLocked = false;
			if (StringUtils.equals(AuthConstant.STATUS_VALID, sysUser.getStatus())){
				notLocked = true;
			}
			DklAuthUser authUser = new DklAuthUser(sysUser.getUsername(), sysUser.getPassword(), true, true, true, notLocked,
					AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

			BeanUtils.copyProperties(sysUser,authUser);
			return authUser;
		} else {
			throw new UsernameNotFoundException("");
		}
	}


}

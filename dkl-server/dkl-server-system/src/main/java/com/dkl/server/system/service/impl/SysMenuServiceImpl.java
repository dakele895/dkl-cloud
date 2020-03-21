package com.dkl.server.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dkl.entity.system.SysMenu;
import com.dkl.router.RouterMeta;
import com.dkl.router.VueRouter;
import com.dkl.server.system.mapper.SysMenuMapper;
import com.dkl.server.system.service.SysMenuService;
import com.dkl.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单表  服务实现类
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

	@Override
	public Set<String> findUserPermissions(String username) {
		List<SysMenu> userPermissions = this.baseMapper.findUserPermissions(username);
		return userPermissions.stream().map(SysMenu::getPerms).collect(Collectors.toSet());
	}

	@Override
	public List<VueRouter<SysMenu>> getUserRouters(String username) {
		List<VueRouter<SysMenu>> routes = new ArrayList<>();
		List<SysMenu> menus = this.baseMapper.findUserMenus(username);
		menus.forEach(menu -> {
			VueRouter<SysMenu> route = new VueRouter<>();
			route.setId(menu.getMenuId().toString());
			route.setParentId(menu.getParentId().toString());
			route.setPath(menu.getPath());
			route.setComponent(menu.getComponent());
			route.setName(menu.getMenuName());
			route.setMeta(new RouterMeta(menu.getMenuName(), menu.getIcon()));
			routes.add(route);
		});
		return TreeUtil.buildVueRouter(routes);
	}
}

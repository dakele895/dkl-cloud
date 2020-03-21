package com.dkl.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dkl.entity.system.SysMenu;
import com.dkl.router.VueRouter;

import java.util.List;
import java.util.Set;


/**
 * <p>
 * 菜单表  服务类
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
public interface SysMenuService extends IService<SysMenu> {

	/**
	 * 通过用户名查询用户权限信息
	 *
	 * @param username 用户名
	 * @return 权限信息
	 */
	Set<String> findUserPermissions(String username);

	/**
	 * 通过用户名创建对应的 Vue路由信息
	 *
	 * @param username 用户名
	 * @return 路由信息
	 */
	List<VueRouter<SysMenu>> getUserRouters(String username);

}

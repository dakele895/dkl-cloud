package com.dkl.server.system.controller;


import com.dkl.entity.DklResponse;
import com.dkl.entity.system.SysMenu;
import com.dkl.router.VueRouter;
import com.dkl.server.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单表  前端控制器
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {


	@Autowired
	private SysMenuService menuService;

	@GetMapping("/{username}")
	public DklResponse getUserRouters(@NotBlank(message = "{required}") @PathVariable String username) {
		Map<String, Object> result = new HashMap<>();
		// 构建用户路由对象
		List<VueRouter<SysMenu>> userRouters = this.menuService.getUserRouters(username);
		// 获取用户权限信息
		Set<String> userPermissions = this.menuService.findUserPermissions(username);
		// 组装数据
		result.put("routes", userRouters);
		result.put("permissions", userPermissions);
		return new DklResponse().data(result);
	}

}


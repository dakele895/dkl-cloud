package com.dkl.server.system.controller;

import com.dkl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 16:01
 * @Description:测试资源服务的使用
 */
@RestController
public class TestController {

	@Autowired
	private SysUserService sysUserService;

    @GetMapping("info")
    public String test(){
        return "febs-server-system";
    }

    @GetMapping("hello")
    public String hello(String name) {
    	sysUserService.getUser(1L);
        return "hello" + name;
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}

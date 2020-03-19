package com.dkl.server.system.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.dkl.entity.DklResponse;
import com.dkl.entity.QueryRequest;
import com.dkl.entity.system.SysUser;
import com.dkl.exception.DklException;
import com.dkl.server.system.service.SysUserService;
import com.dkl.util.DklUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <p>
 * 用户表 用户表 前端控制器
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
	@Autowired
	private SysUserService userService;

	@GetMapping
	@PreAuthorize("hasAnyAuthority('user:view')")
	public DklResponse userList(QueryRequest queryRequest, SysUser user) {
		Map<String, Object> dataTable = DklUtil.getDataTable(userService.findUserDetail(user, queryRequest));
		return new DklResponse().data(dataTable);
	}

	@PostMapping
	@PreAuthorize("hasAnyAuthority('user:add')")
	public void addUser(@Valid SysUser user) throws DklException {
		try {
			this.userService.createUser(user);
		} catch (Exception e) {
			String message = "新增用户失败";
			log.error(message, e);
			throw new DklException(message);
		}
	}

	@PutMapping
	@PreAuthorize("hasAnyAuthority('user:update')")
	public void updateUser(@Valid SysUser user) throws DklException {
		try {
			this.userService.updateUser(user);
		} catch (Exception e) {
			String message = "修改用户失败";
			log.error(message, e);
			throw new DklException(message);
		}
	}

	@DeleteMapping("/{userIds}")
	@PreAuthorize("hasAnyAuthority('user:delete')")
	public void deleteUsers(@NotBlank(message = "{required}") @PathVariable String userIds) throws DklException {
		try {
			String[] ids = userIds.split(StringPool.COMMA);
			this.userService.deleteUsers(ids);
		} catch (Exception e) {
			String message = "删除用户失败";
			log.error(message, e);
			throw new DklException(message);
		}
	}
}


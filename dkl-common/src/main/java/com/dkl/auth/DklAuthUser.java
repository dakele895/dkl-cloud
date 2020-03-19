package com.dkl.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Collection;


/**
 * @author: dalele
 * @date: 2020/3/19 16:38
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DklAuthUser extends User{
	private static final long serialVersionUID = -7129872782160112508L;
	/**
	 * 用户id
	 */
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 部门id
	 */
	private Long deptId;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 联系电话
	 */
	private String mobile;

	/**
	 * 状态 0锁定1有效
	 */
	private String status;

	/**
	 * 最近访问时间
	 */
	private LocalDateTime lastLoginTime;

	/**
	 * 性别 0男1女2保密
	 */
	private String ssex;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 创建人
	 */
	private String createdBy;

	/**
	 * 创建时间
	 */
	private LocalDateTime createdTime;

	/**
	 * 更新人
	 */
	private String updatedBy;

	/**
	 * 更新时间
	 */
	private LocalDateTime updatedTime;

	/**
	 * 角色 ID
	 */
	@TableField(exist = false)
	private String roleId;

	@TableField(exist = false)
	private String roleName;

	/**
	 * 部门名称
	 */
	@TableField(exist = false)
	private String deptName;


	public DklAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public DklAuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
}

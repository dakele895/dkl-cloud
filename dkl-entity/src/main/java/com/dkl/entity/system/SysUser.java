package com.dkl.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表 用户表
 * </p>
 *
 * @author dkl
 * @since 2020-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
	@Size(min = 4, max = 10, message = "{range}")
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
	@Size(max = 50, message = "{noMoreThan}")
	@Email(message = "{email}")
    private String email;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 状态 0锁定1有效
     */
	@NotBlank(message = "{required}")
    private String status;

    /**
     * 最近访问时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 性别 0男1女2保密
     */
	@NotBlank(message = "{required}")
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
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

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

}

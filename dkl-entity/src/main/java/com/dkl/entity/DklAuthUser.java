package com.dkl.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 02:40
 * @Description:认证用户实体类
 */
@Data
public class DklAuthUser implements Serializable {


    private static final long serialVersionUID = 5305480618832406222L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 账户未过期
     */
    private boolean accountNonExpired = true;

    /**
     * 账号未锁定
     */
    private boolean accountNonLocked= true;

    /**
     * 凭证未过期
     */
    private boolean credentialsNonExpired= true;

    /**
     * 是否启用
     */
    private boolean enabled= true;
}

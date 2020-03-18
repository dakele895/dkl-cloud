package com.dkl.auth.controller;

import com.dkl.auth.service.ValidateCodeService;
import com.dkl.entity.DklResponse;
import com.dkl.exception.DklAuthException;
import com.dkl.exception.ValidateCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 03:41
 * @Description:
 */
@RestController
public class SecurityController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

	@Autowired
	private ValidateCodeService validateCodeService;

	@GetMapping("captcha")
	public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
		validateCodeService.create(request, response);
	}

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public DklResponse signout(HttpServletRequest request) throws DklAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        DklResponse febsResponse = new DklResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new DklAuthException("退出登录失败");
        }
        return febsResponse.message("退出登录成功");
    }
}

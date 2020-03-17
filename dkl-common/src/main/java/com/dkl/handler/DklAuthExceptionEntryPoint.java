package com.dkl.handler;

import com.alibaba.fastjson.JSONObject;
import com.dkl.entity.DklResponse;
import com.dkl.util.DklUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dalele
 * @date: 2020/3/17 16:55
 * @description:处理资源服务器异常 处理401状态
 */
public class DklAuthExceptionEntryPoint  implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        DklResponse febsResponse = new DklResponse();

        DklUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, febsResponse.message("token无效")
        );
    }
}

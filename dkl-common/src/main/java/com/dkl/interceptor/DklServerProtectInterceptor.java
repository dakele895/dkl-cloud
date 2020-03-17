package com.dkl.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.dkl.constant.DklConstant;
import com.dkl.entity.DklResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dalele
 * @date: 2020/3/17 22:38
 * @description: 开启微服务防护，避免客户端绕过网关直接请求微服务拦截器
 */
public class DklServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(DklConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(DklConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            DklResponse dklResponse = new DklResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(dklResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}

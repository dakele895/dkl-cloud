package com.dkl.gateway.filter;

import com.dkl.entity.DklResponse;
import com.dkl.util.DklUtil;
import com.netflix.zuul.context.RequestContext;
import io.lettuce.core.dynamic.support.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: dalele
 * @date: 2020/3/17 17:16
 * @description:
 */
@Slf4j
@Component
public class DklGatewayErrorFilter extends SendErrorFilter {

    @Override
    public Object run() {
        try {
            DklResponse dklResponse = new DklResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            dklResponse = resolveExceptionMessage(message, serviceId, dklResponse);

            HttpServletResponse response = ctx.getResponse();
            DklUtil.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, dklResponse
            );
            log.error("Zull sendError：{}", dklResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private DklResponse resolveExceptionMessage(String message, String serviceId, DklResponse dklResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return dklResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return dklResponse.message(serviceId + "服务不可用");
        }
        return dklResponse.message("Zuul请求" + serviceId + "服务异常");
    }
}

package com.dkl.gateway.fallback;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.BlockResponse;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackProvider;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpStatus;

/**
 * @author: dalele
 * @date: 2020/3/19 02:20
 * @description:
 */
public class DklGatewayBlockFallbackProvider implements ZuulBlockFallbackProvider {

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public BlockResponse fallbackResponse(String route, Throwable throwable) {
		if (throwable instanceof BlockException) {
			return new BlockResponse(HttpStatus.TOO_MANY_REQUESTS.value(),
					"访问频率超限", route);
		} else {
			return new BlockResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"系统异常", route);
		}
	}
}

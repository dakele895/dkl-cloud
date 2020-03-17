package com.dkl.server.test.service;

import com.dkl.constant.DklServerConstant;
import com.dkl.server.test.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: dalele
 * @date: 2020/3/17 17:41
 * @description:
 */
@FeignClient(value = DklServerConstant.DKL_SERVER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}

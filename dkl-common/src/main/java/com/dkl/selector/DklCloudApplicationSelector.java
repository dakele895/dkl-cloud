package com.dkl.selector;

import com.dkl.config.DklAuthExceptionConfigure;
import com.dkl.config.DklOAuth2FeignConfigure;
import com.dkl.config.DklServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: dalele
 * @date: 2020/3/17 23:44
 * @description: 功能整合类
 */
public class DklCloudApplicationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                //开启微服务防护，避免客户端绕过网关直接请求微服务
                DklAuthExceptionConfigure.class.getName(),
                //开启带令牌的Feign请求，避免微服务内部调用出现401异常
                DklOAuth2FeignConfigure.class.getName(),
                //认证类型异常翻译
                DklServerProtectConfigure.class.getName()
        };
    }
}

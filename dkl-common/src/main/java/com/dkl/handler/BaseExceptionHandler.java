package com.dkl.handler;

import com.dkl.entity.DklResponse;
import com.dkl.exception.DklAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;

/**
 * @author: dalele
 * @date: 2020/3/17 17:24
 * @description: 全局异常
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DklResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new DklResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = DklAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DklResponse handleFebsAuthException(DklAuthException e) {
        log.error("系统错误", e);
        return new DklResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public DklResponse handleAccessDeniedException(){
        return new DklResponse().message("没有权限访问该资源");
    }
}

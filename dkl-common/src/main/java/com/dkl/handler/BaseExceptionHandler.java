package com.dkl.handler;

import com.dkl.entity.DklResponse;
import com.dkl.exception.DklAuthException;
import com.dkl.exception.DklException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Set;

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



	@ExceptionHandler(value = DklException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public DklResponse handleFebsException(DklException e) {
		log.error("系统错误", e);
		return new DklResponse().message(e.getMessage());
	}


	/**
	 * 统一处理请求参数校验(普通传参)
	 *
	 * @param e ConstraintViolationException
	 * @return FebsResponse
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public DklResponse handleConstraintViolationException(ConstraintViolationException e) {
		StringBuilder message = new StringBuilder();
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		for (ConstraintViolation<?> violation : violations) {
			Path path = violation.getPropertyPath();
			String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
			message.append(pathArr[1]).append(violation.getMessage()).append(",");
		}
		message = new StringBuilder(message.substring(0, message.length() - 1));
		return new DklResponse().message(message.toString());
	}


	/**
	 * 统一处理请求参数校验(实体对象传参)
	 *
	 * @param e BindException
	 * @return FebsResponse
	 */
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public DklResponse handleBindException(BindException e) {
		StringBuilder message = new StringBuilder();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		for (FieldError error : fieldErrors) {
			message.append(error.getField()).append(error.getDefaultMessage()).append(",");
		}
		message = new StringBuilder(message.substring(0, message.length() - 1));
		return new DklResponse().message(message.toString());
	}

}

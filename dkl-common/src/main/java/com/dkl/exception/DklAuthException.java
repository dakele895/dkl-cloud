package com.dkl.exception;

/**
 *
 * @auther: dalele
 * @Date: 2020/3/17 03:46
 * @Description:自定义错误实现类
 */
public class DklAuthException  extends Exception{
    private static final long serialVersionUID = -6916154462432027437L;

    public DklAuthException(String message){
        super(message);
    }
}

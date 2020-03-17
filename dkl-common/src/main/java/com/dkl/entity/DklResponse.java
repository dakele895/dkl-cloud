package com.dkl.entity;

import lombok.Data;

import java.util.HashMap;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 03:42
 * @Description:获取当前登录用户
 */
@Data
public class DklResponse extends HashMap<String, Object> {


    private static final long serialVersionUID = 6375497275427199055L;

    public DklResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public DklResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public DklResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }

}

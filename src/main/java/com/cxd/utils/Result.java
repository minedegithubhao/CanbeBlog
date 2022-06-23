package com.cxd.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @author cxd
 * @description: 返回前端的通用类
 * @create: 2022-06-09 07:47
 */
@Data
public class Result<T> {

    private boolean success = true;
    private String message = "";
    private Integer code = 0;
    private T result;

    public Result(){}

    public Result<T> success(Integer code, String message){
        this.success = true;
        this.code = CommonConstant.SC_OK_200;
        this.message = message;
        return this;
    }

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(CommonConstant.SC_OK_200);
        return result;
    }

    public static Result ok(String message){
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage(message);
        result.setCode(CommonConstant.SC_OK_200);
        return result;
    }

    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(CommonConstant.SC_OK_200);
        result.setResult(data);
        return result;
    }

    public static Result failed(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

}

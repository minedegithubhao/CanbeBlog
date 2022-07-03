package com.cxd.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author cxd
 * @description: 返回前端的通用类
 * @create: 2022-06-09 07:47
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> {

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象
     */
    @ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

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

package com.cxd.utils;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
import lombok.Builder;
import lombok.Data;

/**
 * @author cxd
 * @description: 返回前端的通用类
 * @create: 2022-06-09 07:47
 */
@Data
@Builder
public class DataResult {

    private Integer code;
    private String Message;
    private Object data;

    public static DataResult success(Object data){
        return new DataResult(200, "ok", data);
    }

}

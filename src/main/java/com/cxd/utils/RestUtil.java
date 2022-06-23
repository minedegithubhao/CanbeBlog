package com.cxd.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 * @author cxd
 * @description:
 * @create: 2022-06-18 17:42
 */
@Slf4j
public class RestUtil {

    private final static RestTemplate RT;
    static {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(3000);
        RT = new RestTemplate(requestFactory);
        // 解决乱码问题
        RT.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

    /**
     * 发送请求
     *
     * @param url          请求地址
     * @param method       请求方式
     * @param headers      请求头  可空
     * @param variables    请求url参数 可空
     * @param params       请求body参数 可空
     * @param responseType 返回类型
     * @return ResponseEntity<responseType>
     */
    public static <T> ResponseEntity<T> request(String url, HttpMethod method, HttpHeaders headers, JSONObject variables, Object params, Class<T> responseType) {
        log.info(" RestUtil  --- request ---  url = "+ url);
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("url 不能为空");
        }
        if (method == null) {
            throw new RuntimeException("method 不能为空");
        }
        if (headers == null) {
            headers = new HttpHeaders();
        }
        // 请求体
        String body = "";
        if (params != null) {
            if (params instanceof JSONObject) {
                body = ((JSONObject) params).toJSONString();

            } else {
                body = params.toString();
            }
        }
        // 拼接 url 参数
        if (variables != null) {
            url += ("?" + asUrlVariables(variables));
        }
        // 发送请求
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        return RT.exchange(url, method, request, responseType);
    }

    /**
     * 将 JSONObject 转为 a=1&b=2&c=3...&n=n 的形式
     */
    public static String asUrlVariables(JSONObject variables) {
        Map<String, Object> source = variables.getInnerMap();
        Iterator<String> it = source.keySet().iterator();
        StringBuilder urlVariables = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            String value = "";
            Object object = source.get(key);
            if (object != null) {
                if (!StringUtils.isEmpty(object.toString())) {
                    value = object.toString();
                }
            }
            urlVariables.append("&").append(key).append("=").append(value);
        }
        // 去掉第一个&
        return urlVariables.substring(1);
    }
}

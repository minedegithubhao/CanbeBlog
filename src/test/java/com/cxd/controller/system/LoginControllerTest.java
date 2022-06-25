package com.cxd.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.cxd.service.system.BookService;
import com.cxd.utils.CommonConstant;
import com.cxd.utils.JwtUtil;
import com.cxd.utils.RedisUtil;
import com.cxd.utils.RestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LoginControllerTest {

    private final String BASE_URL = "http://localhost:8080/CanbeBlog/sys/login/";
    private final String USERNAME = "admin";
    private final String PASSWORD = "123456";

    @Autowired
    BookService bookService;
    @Autowired
    private RedisUtil redisUtil;

    private String getToken() {
        String token = JwtUtil.sign(USERNAME, PASSWORD);
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
        redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, 60);
        return token;
    }

    private HttpHeaders getHeaders() {
        String token = this.getToken();
        System.out.println("请求Token：" + token);

        HttpHeaders headers = new HttpHeaders();
        String mediaType = MediaType.APPLICATION_JSON_VALUE;
        headers.setContentType(MediaType.parseMediaType(mediaType));
        headers.set("Accept", mediaType);
        headers.set("X-Access-Token", token);
        return headers;
    }

    @Test
    public void testRegister(){
        String url = BASE_URL + "register";
        HttpHeaders headers = this.getHeaders();
        HttpMethod method = HttpMethod.POST;

        System.out.println("请求地址：" + url);
        System.out.println("请求方式：" + method);

        JSONObject params = new JSONObject();
        params.put("username", "cxd");
        params.put("password", "123456");
        params.put("confirmpassword","123456");
        params.put("realname", "单元测试");
        params.put("activitiSync", "1");
        params.put("userIdentity","1");
        params.put("workNo","0025");

        System.out.println("请求参数：" + params.toJSONString());

        // 利用 RestUtil 请求该url
        ResponseEntity<JSONObject> result = RestUtil.request(url, method, headers, params, null, JSONObject.class);
        if (result != null && result.getBody() != null) {
            System.out.println("返回结果：" + result.getBody().toJSONString());
        } else {
            System.out.println("查询失败");
        }
    }
}
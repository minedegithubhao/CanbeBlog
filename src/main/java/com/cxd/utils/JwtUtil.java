package com.cxd.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * @author cxd
 * @description: JWT工具类
 * @create: 2022-06-18 17:58
 */
public class JwtUtil {

    /**Token有效期为1小时（Token在reids中缓存时间为两倍）*/
    public static final long EXPIRE_TIME = 60 * 60 * 1000;


    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param password   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String password) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(password);
        // 附带username信息
        return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
    }
}

package com.cxd.controller;

import com.cxd.entity.system.SysUser;
import com.cxd.service.LoginService;
import com.cxd.utils.DataResult;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author cxd
 * @description:
 * @create: 2022-05-30 21:26
 */
@Controller
@RequestMapping("/system")
public class LoginController {

    @Resource
    LoginService loginService;

//    @RequestMapping("/login1")
//    private String list1() {
//        return "login1";
//    }

//    @RequestMapping("/login2")
//    private String list2() {
//        return  "login2";
//    }

    @RequestMapping("/login")
    private String login() {
        return  "/login/login";
    }

    @RequestMapping("/login/Api")
    @ResponseBody
    private DataResult loginApi(SysUser sysUser){
        SysUser login = loginService.login(sysUser);
        return DataResult.success(login);
    }

    @RequestMapping("/index")
    private String index() {
        return  "/index/index";
    }

}

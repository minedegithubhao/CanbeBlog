package com.cxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxd
 * @description:
 * @create: 2022-05-30 21:26
 */
@Controller
@RequestMapping("/system")
public class LoginController {

    @RequestMapping("/login")
    private String list() {
        return "login";
    }

}

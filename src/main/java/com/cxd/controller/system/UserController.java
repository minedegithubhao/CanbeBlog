package com.cxd.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cxd
 * @description: 用户controller
 * @create: 2022-06-13 21:31
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public String list(){
        return "layout-fluid";
    }
}

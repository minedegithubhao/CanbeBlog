package com.cxd.controller.system;

import com.cxd.entity.system.SysUser;
import com.cxd.service.system.LoginService;
import com.cxd.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author cxd
 * @description:
 * @create: 2022-05-30 21:26
 */
@Controller
@RequestMapping("/sys/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    /**
     * 注册
     * @param sysUser
     * @return DataResult
     */
    @RequestMapping("/register")
    @ResponseBody
    private Result<SysUser> register(SysUser sysUser){

        if (StringUtils.isBlank(sysUser.getRealname())){
            return Result.failed("请输入正确的用户名!");
        }

        SysUser user = loginService.getUserByName(sysUser.getUsername());
        if (Objects.nonNull(user)){
            return Result.failed("用户名已注册");
        }

        try {
            sysUser.setId(UUID.randomUUID().toString().replace("-",""));
            sysUser.setCreateTime(new Date());
            String salt = UUID.randomUUID().toString().replace("-", "");
            String md5password = DigestUtils.md5DigestAsHex((sysUser.getPassword() + salt).getBytes());
            sysUser.setPassword(md5password);
            sysUser.setSalt(salt);
            loginService.register(sysUser);
            return Result.ok("注册成功");
        }catch (Exception e){
            return Result.failed("注册失败");
        }
    }

}

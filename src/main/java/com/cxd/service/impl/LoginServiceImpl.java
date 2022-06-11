package com.cxd.service.impl;

import com.cxd.dao.system.SysUserMapper;
import com.cxd.entity.system.SysUser;
import com.cxd.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cxd
 * @description: 登陆
 * @create: 2022-06-09 07:43
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        SysUser user = sysUserMapper.findByNameAndPassword(sysUser);
        return user;
    }
}

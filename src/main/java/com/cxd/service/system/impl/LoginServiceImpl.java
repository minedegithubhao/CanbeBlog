package com.cxd.service.system.impl;

import com.cxd.dao.system.SysUserMapper;
import com.cxd.entity.system.SysUser;
import com.cxd.service.system.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cxd
 * @description: 登陆
 * @create: 2022-06-09 07:43
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        SysUser user = sysUserMapper.findByNameAndPassword(sysUser);
        return user;
    }

    @Override
    public int register(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public SysUser getUserByName(String username) {
        return sysUserMapper.getUserByName(username);
    }
}

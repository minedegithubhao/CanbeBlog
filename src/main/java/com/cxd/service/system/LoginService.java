package com.cxd.service.system;

import com.cxd.entity.system.SysUser;

public interface LoginService {

    SysUser login(SysUser sysUser);

    int register(SysUser sysUser);

    SysUser getUserByName(String username);
}

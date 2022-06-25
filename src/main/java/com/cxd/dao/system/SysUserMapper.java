package com.cxd.dao.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxd.entity.system.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {

    int insert(SysUser record);

    SysUser findByNameAndPassword(SysUser sysUser);

    SysUser getUserByName(String username);
}
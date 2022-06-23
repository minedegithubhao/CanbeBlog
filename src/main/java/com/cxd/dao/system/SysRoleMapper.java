package com.cxd.dao.system;

import com.cxd.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(String id);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);
}
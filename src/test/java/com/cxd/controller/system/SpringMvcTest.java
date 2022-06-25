package com.cxd.controller.system;

import com.cxd.dao.system.SysUserMapper;
import com.cxd.dao.system.UserMapper;
import com.cxd.entity.system.SysUser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author cxd
 * @description: mybatis-plus测试
 * @create: 2022-06-25 09:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringMvcTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = userMapper.selectList(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);

        SysUser sysUser = sysUserMapper.selectByPrimaryKey("a75d45a015c44384a04449ee80dc3503");
        System.out.println(sysUser);
    }
}

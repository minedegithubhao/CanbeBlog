package com.cxd.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxd.dao.system.SysUserMapper;
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
    SysUserMapper sysUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = sysUserMapper.selectList(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);

        System.out.println(("----- 分页 ------"));
        IPage<SysUser> page = new Page<>();
        page.setSize(3);
        page.setCurrent(2);
        IPage<SysUser> page1 = sysUserMapper.selectPage(page, null);
//        Assertions.assertEquals(3, page1.getRecords().size());
        page1.getRecords().stream().forEach(System.out::println);
    }
}

package org.oizehsgl.sub;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.SysUser;
import org.oizehsgl.sub.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {
    @Autowired
    private SysUserMapper userMapper;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp() {
        Assert.isTrue(true);
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = userMapper.selectList(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }


}

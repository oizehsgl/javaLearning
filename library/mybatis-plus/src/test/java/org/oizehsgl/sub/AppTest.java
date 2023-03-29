package org.oizehsgl.sub;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.SysUser;
import org.oizehsgl.sub.service.ISysUserService;
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
    private ISysUserService sysUserService;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp() {
        Assert.isTrue(true,"");
    }

    @Test
    public void list() {
        System.out.println("----------------");
        sysUserService.list(null).forEach(System.out::println);
    }

    /**
     * FieldStrategy
     */
    @Test
    public void updateBatchById(){
        List<SysUser> sysUserList = sysUserService.list(null);
        int i=1;
        for (SysUser sysUser : sysUserList) {
           sysUser.setAge(i++);
           sysUser.setName(null);
           sysUser.setEmail(null);
        }
        sysUserService.updateBatchById(sysUserList);
        list();
    }

    /**
     * UpdateWrapper
     */
    @Test
    public void update(){
        UpdateWrapper uw = new UpdateWrapper();
        uw.set("email",null);
        uw.in("id",new Long[]{-1L,1L,2L});
        sysUserService.update(uw);
        list();
        LambdaUpdateWrapper<SysUser> lambdaUpdateWrapper= Wrappers.<SysUser>lambdaUpdate()
                .set(SysUser::getEmail, null)
                .in(SysUser::getId, new Long[]{4L, 5L, 100L});
        sysUserService.update(lambdaUpdateWrapper);
        list();
        new LambdaUpdateChainWrapper<SysUser>(sysUserService.getBaseMapper())
                .set(SysUser::getEmail, null)
                .in(SysUser::getId, new Long[]{7L, 8L})
                .update();
        list();
    }

    /**
     * QueryWrapper
     */
    @Test
    public void query() {
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq(false,"id", 11);
        sysUserService.list(qw).forEach(System.out::println);
        qw.clear();
        qw.eq(true,"id", 11);
        sysUserService.list(qw).forEach(System.out::println);
    }
}

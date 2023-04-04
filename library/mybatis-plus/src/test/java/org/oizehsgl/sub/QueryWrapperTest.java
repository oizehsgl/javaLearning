package org.oizehsgl.sub;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.entity.SysUser;
import org.oizehsgl.sub.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * queryWrapperTest
 *
 * @author oizehsgl
 * @since 4/4/23
 */
@SpringBootTest
public class QueryWrapperTest {
    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void testQueryWrapper() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true, "id", 11);
        sysUserService.list(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void testQueryLambdaWrapper() {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(true, SysUser::getId, 11);
        sysUserService.list(lambdaQueryWrapper).forEach(System.out::println);
        sysUserService.lambdaQuery().eq(true, SysUser::getId, 11).list().forEach(System.out::println);
    }

    @Test
    public void testQueryLambdaChainWrapper() {
        LambdaQueryChainWrapper<SysUser> lambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(sysUserService.getBaseMapper()).eq(SysUser::getId, 11);
        lambdaQueryChainWrapper.list().forEach(System.out::println);
        new LambdaQueryChainWrapper<>(sysUserService.getBaseMapper()).eq(true, SysUser::getId, 11).list().forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        sysUserService.lambdaQuery().eq(true, SysUser::getId, 11).select(SysUser::getId, SysUser::getName).list().forEach(System.out::println);
    }
}

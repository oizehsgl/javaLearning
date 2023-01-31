package org.oizehsgl.sub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.sub.entity.SysUser;
import org.oizehsgl.sub.mapper.SysUserMapper;
import org.oizehsgl.sub.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * user服务
 *
 * @author oizehsgl
 * @since 2023/1/31
 */
@Service
public class SysUserServiceServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}

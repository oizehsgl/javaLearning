package org.oizehsgl.sub.example.service.impl;

import org.oizehsgl.sub.example.entity.User;
import org.oizehsgl.sub.example.mapper.UserMapper;
import org.oizehsgl.sub.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-09 02:02:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

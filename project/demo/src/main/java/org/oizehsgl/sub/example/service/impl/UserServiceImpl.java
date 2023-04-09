package org.oizehsgl.sub.example.service.impl;

import org.oizehsgl.sub.example.entity.User;
import org.oizehsgl.sub.example.mapper.UserMapper;
import org.oizehsgl.sub.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  业务实现
 * </p>
 *
 * @author 123456
 * @since 2023-04-09 03:24:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

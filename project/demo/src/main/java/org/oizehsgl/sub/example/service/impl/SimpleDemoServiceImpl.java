package org.oizehsgl.sub.example.service.impl;

import org.oizehsgl.sub.example.entity.SimpleDemo;
import org.oizehsgl.sub.example.mapper.SimpleDemoMapper;
import org.oizehsgl.sub.example.service.SimpleDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 简单示例表 业务实现
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-09 11:13:41
 */
@Service
public class SimpleDemoServiceImpl extends ServiceImpl<SimpleDemoMapper, SimpleDemo> implements SimpleDemoService {

}

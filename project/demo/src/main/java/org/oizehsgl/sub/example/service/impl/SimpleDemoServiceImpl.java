package org.oizehsgl.sub.example.service.impl;

import org.oizehsgl.sub.example.entity.SimpleDemo;
import org.oizehsgl.sub.example.mapper.SimpleDemoMapper;
import org.oizehsgl.sub.example.service.SimpleDemoService;
import org.oizehsgl.sub.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 简单示例表 业务实现
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-10 12:36:16
 */
@Service
public class SimpleDemoServiceImpl extends BaseServiceImpl<SimpleDemoMapper, SimpleDemo> implements SimpleDemoService {

}

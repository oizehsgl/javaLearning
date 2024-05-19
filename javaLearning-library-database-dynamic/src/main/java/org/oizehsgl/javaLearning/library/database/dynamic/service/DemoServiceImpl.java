package org.oizehsgl.javaLearning.library.database.dynamic.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.javaLearning.library.database.dynamic.entity.DemoEntity;
import org.oizehsgl.javaLearning.library.database.dynamic.mapper.DemoMapper;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Service
// @DS("master")
// @DS("slave")
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoEntity> implements DemoService {}

package org.oizehsgl.datasource.dynamic.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.datasource.dynamic.entity.DemoEntity;
import org.oizehsgl.datasource.dynamic.mapper.DemoMapper;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
// @DS("master")
// @DS("slave")
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoEntity> implements DemoService {}

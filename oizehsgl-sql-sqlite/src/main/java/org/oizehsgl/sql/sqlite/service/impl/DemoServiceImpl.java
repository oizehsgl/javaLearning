package org.oizehsgl.sql.sqlite.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.sql.sqlite.entity.DemoEntity;
import org.oizehsgl.sql.sqlite.mapper.DemoMapper;
import org.oizehsgl.sql.sqlite.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * 示例service实现
 *
 * @author oizehsgl
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoEntity> implements DemoService {}

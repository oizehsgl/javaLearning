package org.oizehsgl.javaLearning.library.database.sqlite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.javaLearning.library.database.sqlite.entity.DemoEntity;
import org.oizehsgl.javaLearning.library.database.sqlite.mapper.DemoMapper;
import org.oizehsgl.javaLearning.library.database.sqlite.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * 示例service实现
 *
 * @author yueyuanzhi
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoEntity> implements DemoService {
}

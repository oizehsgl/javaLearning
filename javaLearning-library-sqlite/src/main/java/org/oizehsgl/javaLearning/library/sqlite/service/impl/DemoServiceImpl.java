package org.oizehsgl.javaLearning.library.sqlite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.javaLearning.library.sqlite.Po.DemoPo;
import org.oizehsgl.javaLearning.library.sqlite.mapper.DemoMapper;
import org.oizehsgl.javaLearning.library.sqlite.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * 示例service实现
 *
 * @author yueyuanzhi
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoPo> implements DemoService {
}

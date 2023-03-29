package org.oizehsgl.sub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.sub.entity.LogicDelete;
import org.oizehsgl.sub.mapper.LogicDeleteMapper;
import org.oizehsgl.sub.service.LogicDeleteService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * logicDeleteServiceImpl
 *
 * @author oizehsgl
 * @since 3/29/23
 */
@Service
public class LogicDeleteServiceImpl extends ServiceImpl<LogicDeleteMapper, LogicDelete> implements LogicDeleteService {
    @Override
    public List<LogicDelete> findDeleted() {
        return this.baseMapper.findfree(true);
    }

    @Override
    public List<LogicDelete> findOdd() {
        return this.baseMapper.findOdd();
    }

    @Override
    public List<LogicDelete> findEven() {
        return null;
    }
}

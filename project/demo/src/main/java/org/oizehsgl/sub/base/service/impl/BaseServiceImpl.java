package org.oizehsgl.sub.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.sub.base.mapper.IBaseMapper;
import org.oizehsgl.sub.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * baseServiceImpl
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@Service
public class BaseServiceImpl<M extends IBaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {
    @Autowired
    protected M iBaseMapper;
    @Override
    public int deleteAll() {
        return iBaseMapper.deleteAll();
    }
}

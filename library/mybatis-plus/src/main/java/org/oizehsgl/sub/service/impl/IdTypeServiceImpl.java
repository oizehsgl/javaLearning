package org.oizehsgl.sub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.oizehsgl.sub.entity.IdType;
import org.oizehsgl.sub.mapper.IdTypeMapper;
import org.oizehsgl.sub.service.IdTypeService;
import org.springframework.stereotype.Service;

/**
 * idType impl
 *
 * @author oizehsgl
 * @since 3/7/23
 */
@Service
public class IdTypeServiceImpl extends ServiceImpl<IdTypeMapper, IdType> implements IdTypeService {
}

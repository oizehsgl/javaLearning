package org.oizehsgl.sub.example.mapper;

import org.oizehsgl.sub.example.entity.SimpleDemo;
import org.oizehsgl.sub.base.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 简单示例表 Mapper 数据持久
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-10 12:56:56
 */
@Mapper
public interface SimpleDemoMapper extends IBaseMapper<SimpleDemo> {

}

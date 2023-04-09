package org.oizehsgl.sub.example.mapper;

import org.oizehsgl.sub.example.entity.SimpleDemo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 简单示例表 Mapper 数据持久
 * </p>
 *
 * @author oizehsgl
 * @since 2023-04-09 10:07:16
 */
@Mapper
public interface SimpleDemoMapper extends BaseMapper<SimpleDemo> {

}

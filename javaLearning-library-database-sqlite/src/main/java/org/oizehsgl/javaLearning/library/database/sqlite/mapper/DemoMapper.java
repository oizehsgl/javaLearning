package org.oizehsgl.javaLearning.library.database.sqlite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.oizehsgl.javaLearning.library.database.sqlite.entity.DemoEntity;

/**
 * 示例mapper
 *
 * @author oizehsgl
 */
@Mapper
public interface DemoMapper extends BaseMapper<DemoEntity> {
}

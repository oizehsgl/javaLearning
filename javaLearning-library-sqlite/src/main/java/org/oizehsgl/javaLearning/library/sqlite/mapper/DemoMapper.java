package org.oizehsgl.javaLearning.library.sqlite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.oizehsgl.javaLearning.library.sqlite.Po.DemoPo;
import org.springframework.stereotype.Repository;

/**
 * 示例mapper
 *
 * @author yueyuanzhi
 */
@Mapper
public interface DemoMapper extends BaseMapper<DemoPo> {
}

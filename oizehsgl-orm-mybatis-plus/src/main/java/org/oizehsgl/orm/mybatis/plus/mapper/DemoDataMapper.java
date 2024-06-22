package org.oizehsgl.orm.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.oizehsgl.orm.mybatis.plus.model.DemoDataEntity;

/**
 * @author oizehsgl
 */
@Mapper
public interface DemoDataMapper extends BaseMapper<DemoDataEntity> {
  @Select("select * from demo_data where deleted = #{deleted}")
  @Results({@Result(property = "id", column = "id"), @Result(property = "name", column = "email")})
  List<DemoDataEntity> findDeleted(@Param("deleted") boolean deleted);

  List<DemoDataEntity> findOdd();
}

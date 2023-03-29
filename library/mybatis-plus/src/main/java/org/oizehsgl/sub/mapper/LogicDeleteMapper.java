package org.oizehsgl.sub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.oizehsgl.sub.entity.LogicDelete;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * logicDeleteMapper
 *
 * @author oizehsgl
 * @since 3/29/23
 */
@Repository
public interface LogicDeleteMapper extends BaseMapper<LogicDelete> {
    @Select("select * from logic_delete where deleted = #{flag}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "data", column = "id")
    })
    List<LogicDelete> findfree(@Param("flag") boolean deleted);

    List<LogicDelete> findOdd();

    List<LogicDelete> findEven();
}

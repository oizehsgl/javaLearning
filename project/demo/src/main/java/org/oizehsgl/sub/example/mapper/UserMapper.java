package org.oizehsgl.sub.example.mapper;

import org.oizehsgl.sub.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 数据持久
 * </p>
 *
 * @author 123456
 * @since 2023-04-09 03:24:43
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

package org.oizehsgl.sub.example.mapper;

import org.oizehsgl.sub.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 柯南
 * @since 2023-04-09 12:33:09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

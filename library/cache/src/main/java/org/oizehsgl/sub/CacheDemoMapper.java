package org.oizehsgl.sub;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * cacheDemoMapper
 *
 * @author oizehsgl
 * @since 4/7/23
 */
@Mapper
//@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
//@CacheNamespace
public interface CacheDemoMapper extends BaseMapper<CacheDemo> {
}

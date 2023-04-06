package org.oizehsgl.sub;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * iCacheDemoService
 *
 * @author oizehsgl
 * @since 4/7/23
 */
public interface ICacheDemoService extends IService<CacheDemo> {
    List<CacheDemo> listCache();
}

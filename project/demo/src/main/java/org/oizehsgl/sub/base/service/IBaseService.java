package org.oizehsgl.sub.base.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * iBaseService
 *
 * @author oizehsgl
 * @since 4/9/23
 */
public interface IBaseService<T> extends IService<T> {

    int deleteAll();
}
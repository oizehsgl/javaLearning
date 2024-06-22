package org.oizehsgl.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.*;

/**
 * @author oizehsgl
 */
public interface BaseService<T> extends IService<T> {

  boolean upsert(Collection<T> entityList);

  boolean upsert(Collection<T> entities, int batchSize);

  boolean updateBatchByWrapper(Collection<? extends Wrapper<T>> wrappers);

  boolean updateBatchByWrapper(Collection<? extends Wrapper<T>> wrappers, int batchSize);
}

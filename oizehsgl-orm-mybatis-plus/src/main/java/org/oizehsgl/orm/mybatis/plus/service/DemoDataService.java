package org.oizehsgl.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import org.oizehsgl.orm.mybatis.plus.model.DemoDataEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oizehsgl
 */
public interface DemoDataService extends BaseService<DemoDataEntity> {

  @Transactional(rollbackFor = Exception.class)
  void updateBatchByQueryWrapper(
      Collection<DemoDataEntity> entityList,
      Function<DemoDataEntity, QueryWrapper<DemoDataEntity>> queryWrapperFunction);

  List<DemoDataEntity> findDeleted(Boolean deleted);

  List<DemoDataEntity> findOdd();
}

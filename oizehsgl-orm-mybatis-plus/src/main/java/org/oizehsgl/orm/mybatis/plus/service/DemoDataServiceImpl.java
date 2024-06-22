package org.oizehsgl.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.*;
import java.util.*;
import java.util.function.Function;
import org.apache.ibatis.binding.MapperMethod;
import org.oizehsgl.orm.mybatis.plus.mapper.DemoDataMapper;
import org.oizehsgl.orm.mybatis.plus.model.DemoDataEntity;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Service
public class DemoDataServiceImpl extends BaseServiceImpl<DemoDataMapper, DemoDataEntity>
    implements DemoDataService {

  /**
   * 根据queryWrapper批量更新
   *
   * @param entityList 实体类列表
   * @param queryWrapperFunction 方法
   */
  public void updateBatchByQueryWrapper(
      Collection<DemoDataEntity> entityList,
      Function<DemoDataEntity, QueryWrapper<DemoDataEntity>> queryWrapperFunction) {
    String sqlStatement = this.getSqlStatement(SqlMethod.UPDATE);
    this.executeBatch(
        entityList,
        DEFAULT_BATCH_SIZE,
        (sqlSession, entity) -> {
          MapperMethod.ParamMap<Object> param = new MapperMethod.ParamMap<>();
          param.put(Constants.ENTITY, entity);
          param.put(Constants.WRAPPER, queryWrapperFunction.apply(entity));
          sqlSession.update(sqlStatement, param);
        });
  }

  public List<DemoDataEntity> findDeleted(Boolean deleted) {
    return this.baseMapper.findDeleted(deleted);
  }

  public List<DemoDataEntity> findOdd() {
    return this.baseMapper.findOdd();
  }
}

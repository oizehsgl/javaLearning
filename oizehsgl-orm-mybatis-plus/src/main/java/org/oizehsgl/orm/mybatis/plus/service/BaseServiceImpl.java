package org.oizehsgl.orm.mybatis.plus.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import java.util.*;
import java.util.function.Consumer;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oizehsgl
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

  @Transactional(rollbackFor = Exception.class)
  public boolean upsert(Collection<T> entityList) {
    return upsert(entityList, DEFAULT_BATCH_SIZE);
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean upsert(Collection<T> entities, int batchSize) {
    if (CollectionUtils.isEmpty(entities)) return false;
    TableInfo tableInfo = TableInfoHelper.getTableInfo(getEntityClass());
    Assert.notNull(
        tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!");
    String keyProperty = tableInfo.getKeyProperty();
    Assert.notEmpty(
        keyProperty, "error: can not execute. because can not find column for id from entity!");
    String selectSqlStatement = getSqlStatement(SqlMethod.SELECT_OBJS);
    String insertSqlStatement = getSqlStatement(SqlMethod.INSERT_ONE);
    String updateSqlStatement = getSqlStatement(SqlMethod.UPDATE_BY_ID);
    Consumer<SqlSession> consumer =
        sqlSession -> {
          int size = entities.size();
          int idxLimit = Math.min(batchSize, size);
          int i = 1;
          // 批处理临时集合
          List<T> batchList = new ArrayList<>();
          for (T element : entities) {
            batchList.add(element);
            // 批处理
            if (i == idxLimit) {
              // 批数据id集合
              List<Object> idList =
                  batchList.stream()
                      .map(e -> tableInfo.getPropertyValue(e, keyProperty))
                      .filter(StringUtils::checkValNotNull)
                      .toList();
              // 查询批数据中已存在的id集合
              List<Object> existedIdList = null;
              if (!idList.isEmpty()) {
                Map<String, Object> params = new HashMap<>();
                params.put(
                    Constants.WRAPPER,
                    Wrappers.query().select(keyProperty).in(keyProperty, idList));
                existedIdList = sqlSession.selectList(selectSqlStatement, params);
              }
              // 遍历批数据
              for (T entity : batchList) {
                Object id = tableInfo.getPropertyValue(entity, keyProperty);
                if (StringUtils.checkValNull(id)
                    || CollectionUtils.isEmpty(existedIdList)
                    || !existedIdList.contains(id)) {
                  sqlSession.insert(insertSqlStatement, entity);
                } else {
                  MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
                  param.put(Constants.ENTITY, entity);
                  sqlSession.update(updateSqlStatement, param);
                }
              }
              // 提交sql
              sqlSession.flushStatements();
              idxLimit = Math.min(idxLimit + batchSize, size);
              // 清空已处理的数据
              batchList.clear();
            }
            i++;
          }
        };
    return SqlHelper.executeBatch(getSqlSessionFactory(), log, consumer);
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean updateBatchByWrapper(Collection<? extends Wrapper<T>> wrappers) {
    return updateBatchByWrapper(wrappers, DEFAULT_BATCH_SIZE);
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean updateBatchByWrapper(Collection<? extends Wrapper<T>> wrappers, int batchSize) {
    String sqlStatement = getSqlStatement(SqlMethod.UPDATE);
    return executeBatch(
        wrappers,
        batchSize,
        (sqlSession, ew) -> {
          MapperMethod.ParamMap<Wrapper<T>> param = new MapperMethod.ParamMap<>();
          param.put(Constants.ENTITY, null);
          param.put(Constants.WRAPPER, ew);
          sqlSession.update(sqlStatement, param);
        });
  }
}

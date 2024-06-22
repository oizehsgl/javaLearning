package org.oizehsgl.orm.mybatis.plus.service;

import static org.junit.jupiter.api.Assertions.*;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.oizehsgl.orm.mybatis.plus.model.DemoDataEntity;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoDataServiceTest {
  @Resource private DemoDataService demoDataService;

  @Test
  public void list() {
    demoDataService.list().forEach(System.out::println);
  }

  @Test
  public void updateBatchById() {
    list();
    List<DemoDataEntity> demoDataEntityList =
        List.of(
            DemoDataEntity.builder().id(1L).name("update1").build(),
            DemoDataEntity.builder().id(2L).name("update2").build());
    demoDataService.updateBatchById(demoDataEntityList);
    list();
  }

  @Test
  public void updateBatchByQueryWrapper() {
    list();
    List<DemoDataEntity> demoDataEntityList =
        List.of(
            DemoDataEntity.builder().age(11).name("update").build(),
            DemoDataEntity.builder().age(12).name("update").build());
    demoDataService.updateBatchByQueryWrapper(
        demoDataEntityList, e -> new QueryWrapper<DemoDataEntity>().eq("age", e.getAge()));
    list();
  }

  @Test
  public void updateBatchByWrapper() {
    list();
    //DemoDataEntity.builder().deleted()
    List<Wrapper<DemoDataEntity>> wrapperList =
        List.of(
            Wrappers.<DemoDataEntity>lambdaUpdate()
                .eq(DemoDataEntity::getAge, 14)
                .set(DemoDataEntity::getName, "update")
                .set(false, DemoDataEntity::getEmail, null),
            Wrappers.<DemoDataEntity>lambdaUpdate()
                .eq(DemoDataEntity::getAge, 15)
                .set(DemoDataEntity::getName, "update")
                .set(true, DemoDataEntity::getEmail, null));
    demoDataService.updateBatchByWrapper(wrapperList);
    list();
  }

  @Test
  public void findDeleted() {
    demoDataService.findDeleted(false).forEach(System.out::println);
  }

  @Test
  public void findOdd() {
    demoDataService.findOdd().forEach(System.out::println);
  }
}

package org.oizehsgl.guava.cache.cache;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoCacheServiceTest {

  @Resource private DemoCacheService demoCacheService;
  private Integer k;
  private String v;

  @BeforeEach
  void setUp() {
    k = 1;
    v = "v";
  }

  @AfterEach
  void tearDown() {
    k = null;
    v = null;
    demoCacheService.invalidateAll();
  }

  @Test
  void get() {
    String v1 = demoCacheService.get(k);
    String v2 = demoCacheService.get(k);
    Assertions.assertEquals(v1, v2);
  }

  @Test
  void testGet() {
    String v1 = demoCacheService.get(k, () -> v);
    Assertions.assertEquals(v, v1);
  }

  @Test
  void getIfPresent() {
    String v1 = demoCacheService.getIfPresent(k);
    Assertions.assertNull(v1);
    demoCacheService.put(k, v);
    String v2 = demoCacheService.getIfPresent(k);
    Assertions.assertEquals(v, v2);
  }

  @Test
  void put() {
    demoCacheService.put(k, v);
    String v1 = demoCacheService.getIfPresent(k);
    Assertions.assertEquals(v, v1);
    v = "vv";
    demoCacheService.put(k, v);
    String v2 = demoCacheService.getIfPresent(k);
    Assertions.assertEquals(v, v2);
  }

  @Test
  void asMap() {
    Map<Integer, String> integerStringMap = demoCacheService.asMap();
    System.out.println(integerStringMap);
  }

  @Test
  void invalidate() {
    demoCacheService.put(k, v);
    demoCacheService.invalidate(k);
    String v1 = demoCacheService.getIfPresent(k);
    Assertions.assertNull(v1);
  }

  @Test
  void invalidateAll() {
    Stream<Integer> integerStream = IntStream.range(0, 9).boxed();
    integerStream.forEach(i -> demoCacheService.put(i, String.valueOf(i)));
    List<Integer> integerList = IntStream.range(0, 5).boxed().toList();
    demoCacheService.invalidateAll(integerList);
    for (int i = 0; i < 5; i++) {
      k = i;
      String v = demoCacheService.getIfPresent(k);
      Assertions.assertNull(v);
    }
  }

  @Test
  void stats() {
    System.out.println(demoCacheService.stats());
  }
}

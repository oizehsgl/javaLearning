package org.oizehsgl.util.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
public class DateUtilTest {
  @Test
  public void test() {
    System.out.println(DateUtil.parse("2022-06-01"));
    System.out.println(DateUtil.parse("2022-06-01T00:00:02"));
  }
}

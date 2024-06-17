package org.oizehsgl.springBoot.properties;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class PropertyTest {

  @Resource private CustomProperty customProperty;

  @Test
  public void test() {
    System.out.println(customProperty.getP1());
    System.out.println(customProperty.getP2());
    System.out.println(CustomProperty.PP3);
    System.out.println(customProperty.getP4());
    System.out.println(customProperty.getSubProperty().getP1());
    System.out.println(customProperty.getSubProperty().getP2());
  }
}

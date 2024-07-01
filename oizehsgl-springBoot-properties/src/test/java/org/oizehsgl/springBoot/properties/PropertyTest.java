package org.oizehsgl.springBoot.properties;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class PropertyTest {

  @Resource private CustomProperty customProperty;

  @Value("#{${custom.property.p8}}")
  private Map<String, String> p8;

  @Test
  public void test() {
    System.out.println(customProperty.getP1());
    System.out.println(customProperty.getP2());
    System.out.println(CustomProperty.PP3);
    System.out.println(customProperty.getP4());
    System.out.println(customProperty.getP5());
    System.out.println(customProperty.getSubProperty().getP1());
    System.out.println(customProperty.getSubProperty().getP2());
    System.out.println(customProperty.getSubProperty().getP5());
    System.out.println(customProperty.getSubProperty().getP6());
    System.out.println(customProperty.getP7());
    System.out.println(p8);
    System.out.println(p8.get("a"));
    System.out.println(p8.get("b"));
  }
}

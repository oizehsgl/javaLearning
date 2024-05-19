package org.oizehsgl.javaLearning.library.protobuf.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class HelloWorldServiceProtoTest {
  @Test
  public void test() {
    System.out.println(HelloWorldServiceProto.getDescriptor());
  }
}

package org.oizehsgl.rpc.protobuf.service;

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

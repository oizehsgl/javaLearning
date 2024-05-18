package org.oizehsgl.javaLearning.library.protobuf.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class HelloWorldServiceProtoTest {
    @Test
    public void test(){
        System.out.println(HelloWorldServiceProto.getDescriptor());
    }
}
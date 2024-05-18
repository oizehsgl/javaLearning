package org.oizehsgl.javaLearning;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaLearningSpringBootStarterRedisApplicationTests {
	@Resource
	private org.oizehsgl.demo.service.DemoService demoService;

	@Test
	void contextLoads() {
		demoService.demo();
	}

}

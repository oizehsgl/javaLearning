package org.oizehsgl.demo.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.demo.service.DemoService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OizehsglDemoTestSpringBootStarterApplicationTests {
	@Resource
	private DemoService demoService;

	@Test
	void contextLoads() {
		demoService.demo();
	}

}

package org.oizehsgl.starter.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.demo.service.DemoService;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OizehsglStarterTestSpringBootStarterApplicationTests {

	@Test
	void contextLoads() {
	}

	@Resource
	private DemoService demoService;

	@Test
	void test(){
		demoService.demo();
	}
}

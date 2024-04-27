package org.oizehsgl.javaLearning.framework.springBoot.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavaLearningFrameworkSpringBootSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaLearningFrameworkSpringBootSchedulingApplication.class, args);
	}

}

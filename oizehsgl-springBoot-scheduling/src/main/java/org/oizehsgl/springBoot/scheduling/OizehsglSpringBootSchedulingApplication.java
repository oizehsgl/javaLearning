package org.oizehsgl.springBoot.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OizehsglSpringBootSchedulingApplication {

  public static void main(String[] args) {
    SpringApplication.run(OizehsglSpringBootSchedulingApplication.class, args);
  }
}

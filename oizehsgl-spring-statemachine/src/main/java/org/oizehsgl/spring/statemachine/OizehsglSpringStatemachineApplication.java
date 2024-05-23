package org.oizehsgl.spring.statemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.statemachine.data.redis.RedisRepositoryStateMachine;

@SpringBootApplication
public class OizehsglSpringStatemachineApplication {

  public static void main(String[] args) {
    SpringApplication.run(OizehsglSpringStatemachineApplication.class, args);
  }
}


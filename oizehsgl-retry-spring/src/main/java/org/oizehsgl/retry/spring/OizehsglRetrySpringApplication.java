package org.oizehsgl.retry.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@EnableRetry
@SpringBootApplication
public class OizehsglRetrySpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(OizehsglRetrySpringApplication.class, args);
  }
}

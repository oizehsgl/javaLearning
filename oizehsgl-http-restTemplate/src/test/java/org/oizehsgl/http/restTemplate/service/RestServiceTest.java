package org.oizehsgl.http.restTemplate.service;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.oizehsgl.http.restTemplate.OizehsglHttpRestTemplateApplication;
import org.oizehsgl.http.restTemplate.controller.CustomRestController;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author oizehsgl
 */
@SpringBootTest
class RestServiceTest {
  @Resource private RestService restService;

  //@Test
  //@SneakyThrows
  public void test() {
    restService.request(1, "a");
  }
}

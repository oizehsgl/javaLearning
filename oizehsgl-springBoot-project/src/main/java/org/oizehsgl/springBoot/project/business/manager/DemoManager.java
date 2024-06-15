package org.oizehsgl.springBoot.project.business.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 示例通用逻辑层
 *
 * @author oizehsgl
 */
@Slf4j
public class DemoManager {
  public void uploadData() {
    String restUrl = "api/demo/hello/v1";
    reactor.core.publisher.Mono<String> resp =
        WebClient.create()
            .method(HttpMethod.GET)
            .uri(restUrl)
            .cookie("token", "jwt_token")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(String.class);
    // 订阅结果
    resp.subscribe(
        log::info,
        e -> {
          log.info("[error<{}>]", e.getMessage(), e);
        });
  }

  public void acquireData() {
    String restUrl = "api/demo/hello/v1";
    reactor.core.publisher.Mono<String> resp =
        WebClient.create()
            .method(HttpMethod.GET)
            .uri(restUrl)
            .cookie("token", "jwt_token")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToMono(String.class);
    // 订阅结果
    resp.subscribe(
        log::info,
        e -> {
          log.info("[error<{}>]", e.getMessage(), e);
        });
  }
}

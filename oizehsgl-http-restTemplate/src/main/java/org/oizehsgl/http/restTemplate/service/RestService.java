package org.oizehsgl.http.restTemplate.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.http.restTemplate.config.RestTemplateConfiguration;
import org.oizehsgl.http.restTemplate.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author oizehsgl
 */
@Slf4j
@Service
public class RestService {

  @Resource(name = RestTemplateConfiguration.CUSTOM_REST_TEMPLATE)
  private RestTemplate restTemplate;

  public void request(Integer id, String name) {
    String url = "http://localhost:8080/rest/getUserInfo?id={id}&name={name}";
    ResponseEntity<User> result = restTemplate.getForEntity(url, User.class, id, name);
    log.info(
        "请求HTTP[status<{}>,header<{}>,body<{}>]",
        result.getStatusCode(),
        result.getHeaders(),
        result.getBody());
  }
}

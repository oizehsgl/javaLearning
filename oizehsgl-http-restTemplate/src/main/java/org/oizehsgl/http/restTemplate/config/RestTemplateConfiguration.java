package org.oizehsgl.http.restTemplate.config;

import java.nio.charset.StandardCharsets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author oizehsgl
 */
@Configuration
public class RestTemplateConfiguration {
  public static final String CUSTOM_REST_TEMPLATE = "customRestTemplate";

  @Bean(name = CUSTOM_REST_TEMPLATE)
  public RestTemplate customRestTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    // restTemplate.setRequestFactory(getHttpComponentsClientHttpRequestFactory());
    restTemplate.setRequestFactory(getSimpleClientHttpRequestFactory());
    // 支持中文编码
    restTemplate
        .getMessageConverters()
        .set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    return restTemplate;
  }

  /**
   * 使用SimpleClientHttpRequestFactory
   *
   * @return {@link SimpleClientHttpRequestFactory}
   */
  public SimpleClientHttpRequestFactory getSimpleClientHttpRequestFactory() {
    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
    factory.setReadTimeout(5 * 1000);
    factory.setConnectTimeout(10 * 1000);
    return factory;
  }

  /// 不支持SpringBoot3
  ///**
  // * @return {@link HttpComponentsClientHttpRequestFactory}
  // */
  //public HttpComponentsClientHttpRequestFactory getHttpComponentsClientHttpRequestFactory() {
  //  int timeoutSecond = 5;
  //  RequestConfig config =
  //      RequestConfig.custom()
  //          .setConnectTimeout(Timeout.ofSeconds(timeoutSecond))
  //          .setConnectionRequestTimeout(Timeout.ofSeconds(timeoutSecond))
  //          .build();
  //  CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
  //  return new HttpComponentsClientHttpRequestFactory(client);
  //}
}

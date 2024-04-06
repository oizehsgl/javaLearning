package org.oizehsgl.javaLearning.framework.springBoot.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * RestTemplate配置类
 *
 * @author oizehsgl
 * @since 2023/2/3
 */
@Slf4j
@Configuration
public class RestTemplateConfig {
    /**
     * @return {@link RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate() {
        //RestTemplate restTemplate = new RestTemplate(getHttpComponentsClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(getSimpleClientHttpRequestFactory());
        // 支持中文编码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
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
///不支持SpringBoot3
//    /**
//     * @return {@link HttpComponentsClientHttpRequestFactory}
//     */
//    public HttpComponentsClientHttpRequestFactory getHttpComponentsClientHttpRequestFactory() {
//        int timeoutSecond = 5;
//        RequestConfig config = RequestConfig.custom().setConnectTimeout(Timeout.ofSeconds(timeoutSecond)).setConnectionRequestTimeout(Timeout.ofSeconds(timeoutSecond)).build();
//        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
//        return new HttpComponentsClientHttpRequestFactory(client);
//    }
}
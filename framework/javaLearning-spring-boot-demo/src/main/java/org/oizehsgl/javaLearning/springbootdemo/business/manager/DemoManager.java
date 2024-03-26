package org.oizehsgl.javaLearning.springbootdemo.business.manager;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *  示例通用逻辑层
 *
 * @author yueyuanzhi
 */
@Slf4j
public class DemoManager {
    public void uploadData() {
        String restUrl = "api/demo/hello/v1";

        Mono<String> resp = WebClient.create()
                .method(HttpMethod.GET)
                .uri(restUrl)
                .cookie("token", "jwt_token")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(String.class);

        // 订阅结果
        resp.subscribe(responseData -> {
            log.info(responseData.toString());
        }, e -> {
            log.info("error:" + e.getMessage());
        });
    }

    public void acquireData() {
        String restUrl = "api/demo/hello/v1";

        Mono<String> resp = WebClient.create().method(HttpMethod.GET).uri(restUrl).cookie("token", "jwt_token").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve().bodyToMono(String.class);

        // 订阅结果
        resp.subscribe(responseData -> {
            log.info(responseData.toString());
        }, e -> {
            log.info("error:" + e.getMessage());
        });
    }

}

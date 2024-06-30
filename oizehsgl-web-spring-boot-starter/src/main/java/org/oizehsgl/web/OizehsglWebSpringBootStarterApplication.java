package org.oizehsgl.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import java.net.URI;

@SpringBootApplication
public class OizehsglWebSpringBootStarterApplication {

  public static void main(String[] args) {
    SpringApplication.run(OizehsglWebSpringBootStarterApplication.class, args);
  }

  // TODO: 测试
   @RestController
    public static class MyController {

        @GetMapping("/redirect")
        public Mono<Void> redirectToAnotherUrl(ServerWebExchange exchange) {
            // Redirect to another URL
            String redirectUrl = "https://www.geeksforgeeks.org/";

            // Set HTTP status code to 302 (Found) for redirection
            exchange.getResponse().setStatusCode(HttpStatus.FOUND);
            exchange.getResponse().getHeaders().setLocation(URI.create(redirectUrl));

            // End response processing
            return exchange.getResponse().setComplete();
        }
    }

    @Bean
    public WebFilter redirectFilter() {
        return (exchange, chain) -> {
            // Intercept requests and redirect if necessary
            if (exchange.getRequest().getURI().getPath().equals("/old-url")) {
                // Redirect to another URL
                String redirectUrl = "https://example.com/new-url";

                // Set HTTP status code to 302 (Found) for redirection
                exchange.getResponse().setStatusCode(HttpStatus.FOUND);
                exchange.getResponse().getHeaders().setLocation(URI.create(redirectUrl));

                // End response processing
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        };
    }
}

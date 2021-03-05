package com.example.resttemplate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author sskim
 */
@Configuration
@Slf4j
public class WebFluxConfig implements WebFluxConfigurer {

    @Bean
    public WebClient webClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://www.kobis.or.kr")
                .filter(ExchangeFilterFunction.ofRequestProcessor(
                        clientRequest -> {
                            log.debug("Request: {} {}", clientRequest.method(), clientRequest.url());
                            clientRequest.headers()
                                    .forEach((name, values) -> values.forEach(value -> log.debug("{} : {}", name, value)));
                            return Mono.just(clientRequest);
                        }
                ))
                .filter(ExchangeFilterFunction.ofResponseProcessor(
                        clientResponse -> {
                            clientResponse.headers()
                                    .asHttpHeaders()
                                    .forEach((name, values) ->
                                            values.forEach(value -> log.debug("{} : {}", name, value)));
                            return Mono.just(clientResponse);
                        }
                ))
                .build();
        return webClient;
    }
}

package com.example.resttemplate.config;

import com.example.resttemplate.interceptor.RequestResponseLoggingInterceptor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author sskim
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(120)   //연결을 유지할 최대 숫자
                .setMaxConnPerRoute(100)    //특정 경로당 최대 숫자
                .setConnectionTimeToLive(5, TimeUnit.SECONDS)   // keep - alive
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);  //HttpComponentsClientHttpRequestFactory 생성자에 주입

        //인터셉터가 요청 / 응답 로거로서 기능하도록하려면 인터셉터가 처음으로, 클라이언트가 두 번째로 두 번 읽어야한다.
        //기본 구현에서는 응답 스트림을 한 번만 읽을 수 있습니다.
        // 이러한 특정 시나리오를 제공하기 위해 Spring은 BufferingClientHttpRequestFactory 라는 특수 클래스를 제공.
        // 이름에서 알 수 있듯이이 클래스는 여러 용도로 JVM 메모리에서 요청 / 응답을 버퍼링합니다.
        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(factory);

        return restTemplateBuilder
                .requestFactory(() -> bufferingClientHttpRequestFactory)
                .setConnectTimeout(Duration.ofMillis(5000)) //읽기시간초과, ms
                .setReadTimeout(Duration.ofMillis(5000))    //연결시간초과, ms
                .additionalInterceptors(new RequestResponseLoggingInterceptor())
                .build();
    }
}

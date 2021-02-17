package com.example.resttemplate.Controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author sskim
 */
@RestController
public class RestTemplateController {

    final RestTemplate restTemplate;

    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/resttemplate")
    public ResponseEntity<Object> restTemplateTest() {

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "key=799f23355d82c9c14f5e42bbf848130b&targetDt=20210201").build();

        ResponseEntity<Object> exchange = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

        String forObject = restTemplate.getForObject(uri.toString(), String.class);
        System.out.println("forObject = " + forObject);
        System.out.println("exchange = " + exchange);

        HttpStatus statusCode = exchange.getStatusCode();   //상태코드확인
        HttpHeaders headers = exchange.getHeaders();    //헤더정보확인
        Object body = exchange.getBody();   //바디정보확인

        return exchange;
    }
}

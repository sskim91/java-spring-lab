package com.example.resttemplate.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<List<Map<String, Object>>> restTemplateTest() {

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", "799f23355d82c9c14f5e42bbf848130b")
                .queryParam("targetDt", "20210201")
                .build();

        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);

        LinkedHashMap boxOfficeResult = (LinkedHashMap) resultMap.getBody().get("boxOfficeResult");

        List<Map<String, Object>> resultDTO = (List<Map<String, Object>>) boxOfficeResult.get("dailyBoxOfficeList");

        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping("/resttemplateAll")
    public ResponseEntity<Map> restTemplateAllTest() {

        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", "799f23355d82c9c14f5e42bbf848130b")
                .queryParam("targetDt", "20210201")
                .build();

        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);

        return resultMap;
    }

    //영화인 검색
    @GetMapping("/searchpeopleInfo")
    public ResponseEntity<Map> searchpeopleInfo() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleInfo.json";
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", "799f23355d82c9c14f5e42bbf848130b")
                .queryParam("peopleCd", "10055626")
                .build();

        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);

        return resultMap;
    }

    //영화사 상세정보
    @GetMapping("/searchCompanyInfo")
    public ResponseEntity<Map> searchCompanyInfo() {
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyInfo.json";
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", "799f23355d82c9c14f5e42bbf848130b")
                .queryParam("companyCd", "20063188")
                .build();

        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);

        return resultMap;
    }
}

package com.example.resttemplate.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author sskim
 */
@RestController
@RequiredArgsConstructor
public class WebClientController {

    private final WebClient webClient;

    @GetMapping("/webClientRequest")
    public ResponseEntity webClientRequest() throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();

        List<Map> collect = webClient
                .mutate()
                .build()
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path("/kobisopenapi/webservice/rest/people/searchPeopleInfo.json")
                                .queryParam("key", "799f23355d82c9c14f5e42bbf848130b")
                                .queryParam("peopleCd", "10055626")
                                .build()
                )
                .retrieve()
                .bodyToMono(LinkedHashMap.class)
                .flux()
                .toStream()
                .collect(toList());

        System.out.println("movieDTOMono = " + collect);
        String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(collect);
        System.out.println(writeValueAsString);

        LinkedHashMap peopleInfoResult = (LinkedHashMap) collect.get(0).get("peopleInfoResult");
        LinkedHashMap peopleInfo = (LinkedHashMap) peopleInfoResult.get("peopleInfo");


        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(peopleInfoResult);
        String s1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(peopleInfo);
        System.out.println("peopleInfoResult = " + s);
        System.out.println("peopleInfo = " + s1);

        return ResponseEntity.ok(collect);
    }
}

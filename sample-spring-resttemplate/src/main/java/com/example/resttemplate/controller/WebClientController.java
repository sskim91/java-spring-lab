package com.example.resttemplate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author sskim
 */
@RestController
@RequiredArgsConstructor
public class WebClientController {

    private final WebClient webClient;

    @GetMapping("/webClientRequest")
    public ResponseEntity webClientRequest() {

        List<Object> collect = webClient
                .mutate()
                .build()
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/kobisopenapi/webservice/rest/people/searchPeopleInfo.json")
                            .queryParam("key", "799f23355d82c9c14f5e42bbf848130b")
                            .queryParam("peopleCd", "10055626");
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(Object.class)
                .flux()
                .toStream()
                .collect(toList());

        System.out.println("movieDTOMono = " + collect);

        return ResponseEntity.ok(collect);
    }
}

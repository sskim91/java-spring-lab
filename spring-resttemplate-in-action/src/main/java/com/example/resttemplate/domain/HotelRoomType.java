package com.example.resttemplate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author sskim
 */
public enum HotelRoomType {
    SINGLE("single"),
    DOUBLE("double"),
    TRIPLE("triple"),
    QUAD("quad");

    private final static Map<String, HotelRoomType> paramMap = Arrays.stream(HotelRoomType.values()).collect(Collectors.toMap(HotelRoomType::getParam, Function.identity()));
    private final String param;

    HotelRoomType(String param) {
        this.param = param;
    }

    @JsonValue
    public String getParam() {
        return param;
    }

    @JsonCreator
    public static HotelRoomType fromParam(String param) {
        return Optional.ofNullable(param)
                .map(paramMap::get)
                .orElseThrow(() -> new IllegalArgumentException("param is not valid"));
    }

}

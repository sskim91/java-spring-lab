package com.example.resttemplate.domain;

import lombok.Getter;
import lombok.ToString;

/**
 * @author sskim
 */
@Getter
@ToString
public class HotelRoomRequest {

    private String roomNumber;
    private HotelRoomType roomType;

}

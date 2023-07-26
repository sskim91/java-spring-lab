package com.example.resttemplate.controller;

import com.example.resttemplate.domain.HotelRoomRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sskim
 */
@Slf4j
@RestController
public class HotelRoomController {

    @PostMapping(path = "/hotels/{hotelId}/rooms")
    public ResponseEntity<Void> createHotelRoom(@PathVariable Long hotelId,
                                                @RequestBody HotelRoomRequest hotelRoomRequest) {

        log.info("hotelId = {}", hotelId);
        log.info("hotelRoomRequest = {}", hotelRoomRequest);

        return ResponseEntity.ok().build();
    }
}

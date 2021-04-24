package com.sskim.restapi.controller;

import com.sskim.restapi.domain.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sskim
 */
@RestController
public class RestSampleController {

    @PostMapping("/users")
    public ResponseEntity getUsers(@RequestBody UserVO userVO) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userVO);
    }
}

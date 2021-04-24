package com.sskim.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author sskim
 */
@Slf4j
@Controller
public class AjaxSampleController {

    @GetMapping("/ajaxSample")
    public String viewPage() {
        return "ajaxSample";
    }

    @PostMapping("/ajaxSample")
    public ResponseEntity ajaxSample(@RequestBody Map<String, Object> paramMap) {

        log.info("paramMap = {}", paramMap);
        return ResponseEntity.ok(paramMap);
    }

}

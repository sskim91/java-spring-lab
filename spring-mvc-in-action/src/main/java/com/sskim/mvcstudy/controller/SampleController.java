package com.sskim.mvcstudy.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sskim
 */
@Controller
public class SampleController {

    @GetMapping(value = "/event")
    @ResponseBody
    public String eventList() {
        return "event";
    }

    @GetMapping(value = "/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String consumes() {
        return "consumes";
    }

    @GetMapping(value = "/produces", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String produces() {
        return "produces";
    }
}

package com.sskim.mvcstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sskim
 */
@Slf4j
@Controller
public class HelloController {

    @GetMapping("index")
    public String home() {
        return "index";
    }


    @ResponseBody
    @GetMapping("/hello")
    public String helloGet(@RequestParam String username,
                           @RequestParam int age) {

        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok get";
    }

    @ResponseBody
    @PostMapping("/hello")
    public String helloPost(@RequestParam String username,
                           @RequestParam int age) {

        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok post";
    }
}

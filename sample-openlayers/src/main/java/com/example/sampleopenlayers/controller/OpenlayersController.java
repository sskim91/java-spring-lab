package com.example.sampleopenlayers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by sskim on 2021/04/25
 * Github : http://github.com/sskim91
 */
@Controller
public class OpenlayersController {

    @GetMapping("/")
    public String index() {
        return "openlayers/ex01";
    }
}

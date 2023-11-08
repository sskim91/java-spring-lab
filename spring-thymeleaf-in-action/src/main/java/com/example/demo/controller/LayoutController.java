package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sskim
 */
@Controller
public class LayoutController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}

package com.sample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sskim
 */
@Controller
public class HomeController {

    @GetMapping("/ckeditor4")
    public String ckEditor4() {
        return "ckeditor4";
    }

}

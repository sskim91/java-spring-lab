package com.example.mvcnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sskim
 */
@Controller
public class IndexController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

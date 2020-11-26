package com.example.demo.controller;

import model.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * @author sskim
 */
@Controller
public class SampleController {

    @GetMapping("/ex01")
    public String ex1(Model model) {
        ProductVO productVO = ProductVO.builder()
                .price(10000)
                .name("상품A")
                .regDate(new Date())
                .build();

        model.addAttribute("productVO", productVO);

        return "object_mapping";
    }
}

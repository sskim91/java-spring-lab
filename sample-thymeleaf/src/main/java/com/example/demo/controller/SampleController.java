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

    @GetMapping("/ex1")
    public void ex1(Model model) {
        ProductVO productVO = ProductVO.builder()
                .price(10000)
                .description("상품A")
                .availableFrom(new Date())
                .build();

        model.addAttribute("productVO", productVO);
    }
}

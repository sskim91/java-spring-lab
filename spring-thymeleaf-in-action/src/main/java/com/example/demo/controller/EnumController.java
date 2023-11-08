package com.example.demo.controller;

import com.example.demo.model.ModelEnumVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sskim
 */
@Controller
public class EnumController {

    @GetMapping("enum01")
    public String enumExample01(Model model) {

        ModelEnumVO modelEnumVO = new ModelEnumVO();
        model.addAttribute("modelEnumVO", modelEnumVO);

        return "enums";
    }
}

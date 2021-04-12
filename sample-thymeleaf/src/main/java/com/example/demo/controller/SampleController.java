package com.example.demo.controller;

import com.example.demo.model.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author sskim
 */
@Controller
public class SampleController {

    @GetMapping("/ex01")
    public String ex01(Model model) {
        ProductVO productVO = new ProductVO();
        productVO.setName("상품A");
        productVO.setPrice(10000);
        productVO.setRegDate(new Date());

        model.addAttribute("productVO", productVO);

        return "thymeleaf/object_view";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {

        List<ProductVO> productList = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> {
            productList.add(new ProductVO("상품" + i, i * 1000, new Date()));
        });
        model.addAttribute("productList", productList);

        return "thymeleaf/list_view";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("key1", 100);
        map.put("key2", 200);
        map.put("key3", 300);

        model.addAttribute("mapList", map);

        return "thymeleaf/map_view";
    }

    @GetMapping("/ex04")
    public String ex04(Model model) {

        Map<String, List<ProductVO>> map = new HashMap<>();

        List<ProductVO> productList = new ArrayList<>();
        List<ProductVO> productList2 = new ArrayList<>();

        IntStream.range(0, 10).forEach(i -> {
            productList.add(new ProductVO("상품" + i, i * 1000, new Date()));
        });
        IntStream.range(0, 10).forEach(i -> {
            productList2.add(new ProductVO("상품2" + i, i * 100, new Date()));
        });

        map.put("key1", productList);
        map.put("key2", productList2);

        model.addAttribute("mapList", map);

        return "thymeleaf/map_list_view";
    }

    @GetMapping("/ex05")
    public String ex05(Model model) {

        List<Map<String, ProductVO>> mapList = new ArrayList<>();

        Map<String, ProductVO> fakeData = new LinkedHashMap<>();
        fakeData.put("testA", new ProductVO("상품A", 10000, new Date()));
        fakeData.put("testB", new ProductVO("상품B", 5000, new Date()));
        fakeData.put("testC", new ProductVO("상품C", 1000, new Date()));
        mapList.add(fakeData);
        fakeData.clear();
        fakeData.put("testA", new ProductVO("상품A", 10000, new Date()));
        fakeData.put("testB", new ProductVO("상품B", 5000, new Date()));
        fakeData.put("testC", new ProductVO("상품C", 1000, new Date()));

        mapList.add(fakeData);

        model.addAttribute("mapList", mapList);

        return "thymeleaf/list_map_view";
    }
}

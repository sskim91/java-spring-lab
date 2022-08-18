package com.example.pagehelper.controller;

import com.example.pagehelper.domain.User;
import com.example.pagehelper.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sskim
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PageController {

    private final UserMapper mapper;

    @GetMapping("/list")
    public PageInfo<User> getUserList(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return PageInfo.of(mapper.findAll());
    }
}

package com.example.resttemplate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author sskim
 */
@Order(2)
@Component
public class ApplicationRunnerSample2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("두번째 ApplicationRunner");
    }
}

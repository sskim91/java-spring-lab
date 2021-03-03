package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author sskim
 */
@Order(1)
@Component
public class ApplicationRunnerSample implements ApplicationRunner {

    @Value("${foo}")
    private String foo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("args.getOptionNames() = " + args.getOptionNames());
        System.out.println("args.getOptionValues(\"foo\") = " + args.getOptionValues("foo"));
        System.out.println("foo = " + foo);
    }
}

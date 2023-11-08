package com.example.resttemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author sskim
 */
@Component
public class CommandLineRunnerSample implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args)
                .forEach(i -> {
                    System.out.println("CommandLine Arguments = " + i);
                });
    }
}

package com.example.demo.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import nz.net.ultraq.thymeleaf.layoutdialect.decorators.strategies.GroupingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sskim
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect(new GroupingStrategy());
    }
}

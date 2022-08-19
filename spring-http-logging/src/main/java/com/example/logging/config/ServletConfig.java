package com.example.logging.config;

import com.example.logging.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author sskim
 */
@Configuration
public class ServletConfig {

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new LoggingFilter());
        filter.addUrlPatterns("/*");
        return filter;
    }
}

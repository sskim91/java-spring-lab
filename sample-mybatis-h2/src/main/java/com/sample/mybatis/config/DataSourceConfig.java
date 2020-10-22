package com.sample.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author sskim
 */
@Configuration
@MapperScan(basePackages = {"com.sample.mybatis.mapper"})
public class DataSourceConfig {
}

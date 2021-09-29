package com.sample.mybatis.config;

import com.sample.mybatis.enums.BoardType;
import com.sample.mybatis.enums.PaymentType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author sskim
 */
//@Configuration
//@MapperScan(basePackages = {"com.sample.mybatis.mapper"})
public class DataSourceConfig {

    @Bean
    public DataSource customDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:tcp://localhost/~/test")
                .driverClassName("org.h2.Driver")
                .username("sa")
                .password("")
                .build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setTypeAliasesPackage(MyBatisProperties.TYPE_ALIASES_PACKAGE);
        sessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis/config/mybatis-config.xml"));
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/*mapper.xml"));
        sessionFactoryBean.setTypeHandlers(new TypeHandler[]{
                new BoardType.TypeHandler(),
                new PaymentType.TypeHandler()
        });
//        sessionFactoryBean.setTypeHandlersPackage("com.sample.mybatis.enums");

        return sessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

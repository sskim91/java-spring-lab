package com.sample.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void mybatisTest() throws Exception{
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection()) {

            System.out.println("dataSource = " + dataSource);

            assertThat(session).isNotNull();
            assertThat(con).isNotNull();

            System.out.println("session = " + session);
            System.out.println("con = " + con);

        } catch (Exception e) {

        }
    }

}

package com.sample.mybatis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sskim
 */
@SpringBootTest
public class DatabaseConnectionTests {

    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String USER = "sa";
    private static final String PW = "";

    @Test
    @DisplayName("DB Connection 테스트")
    void connectionTest() throws Exception{

        Class.forName(DRIVER);

        try(Connection con = DriverManager.getConnection(URL, USER, PW)){
            System.out.println("con = " + con);
            assertThat(con).isNotNull();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

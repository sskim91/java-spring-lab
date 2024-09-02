package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringResourceInActionApplicationTests {

    @Test
    void contextLoads() {

        final ClassPathResource classPathResource = new ClassPathResource("test.json.gz");
        final String filename = classPathResource.getFilename();

        assertThat(filename).isEqualTo("test.json.gz");
    }

}

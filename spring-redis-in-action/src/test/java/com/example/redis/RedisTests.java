package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sskim
 */
@Slf4j
@SpringBootTest
public class RedisTests {

    /**
     * KEY 다 지우는 명령어 redis-cli FLUSHALL
     */

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Test
    void 기본적인_KEY_VALUE_값_넣기() throws Exception {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("mqnic", "hello");
    }

    @Test
    void 기본적인_KEY_VALUE_값_꺼내오기() {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String mqnic = opsForValue.get("mqnic");
        assertThat(mqnic).isEqualTo("hello");
    }

    @Test
    void LIST_값_넣기() throws Exception {
        ListOperations<String, String> opsForList = redisTemplate.opsForList();
        //LEFT_PUSH: List의 index 0 쪽으로 데이터를 넣습니다. ( redis의 list index는 0부터 시작합니다.)
        //RIGHT_PUSHT: List의 index last 쪽으로 데이터를 넣습니다.
        opsForList.leftPush("mqnic", "m");
        opsForList.leftPush("mqnic", "q");
        opsForList.leftPush("mqnic", "n");
        opsForList.leftPush("mqnic", "i");
        opsForList.leftPush("mqnic", "c");
//        assertThat(opsForList.leftPop("mqnic")).isEqualTo("c");
    }

    @Test
    void LIST_값_순차적_빼기() throws Exception {
        ListOperations<String, String> opsForList = redisTemplate.opsForList();
        assertThat(DataType.LIST).isSameAs(redisTemplate.type("mqnic"));
        //LEFT로 넣고 RIGHT로 빼면 순차적으로 빼진다? LPUSH -> RPOP

        for (int i = 0; i < 5; i++) {
            log.info("opsForList = {}", opsForList.rightPop("mqnic"));
        }
    }
}

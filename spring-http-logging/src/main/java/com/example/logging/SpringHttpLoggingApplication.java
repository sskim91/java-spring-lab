package com.example.logging;

import com.example.logging.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@SpringBootApplication
public class SpringHttpLoggingApplication {

    @GetMapping("/hello")
    public String hello(@RequestParam String time) {
        return "world";
    }

    @PostMapping("/json")
    public ResponseEntity<Person> readServletStream(@RequestBody Person person) {
        person.setName("modify");
        return ResponseEntity.ok(person);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringHttpLoggingApplication.class, args);
    }

}

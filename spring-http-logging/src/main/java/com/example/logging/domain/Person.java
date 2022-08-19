package com.example.logging.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sskim
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
}

package com.example.pagehelper.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sskim
 */
@Getter
@Setter
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String py;

    @Builder
    public User(String id, String name, String py) {
        this.id = id;
        this.name = name;
        this.py = py;
    }
}

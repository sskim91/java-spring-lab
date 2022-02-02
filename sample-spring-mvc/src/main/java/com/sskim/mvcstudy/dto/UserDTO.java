package com.sskim.mvcstudy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sskim
 */
@Getter
@Setter
@Builder
public class UserDTO {

    String username;
    int age;
}

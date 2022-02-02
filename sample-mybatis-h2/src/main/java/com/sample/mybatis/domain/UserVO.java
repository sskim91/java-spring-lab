package com.sample.mybatis.domain;

import com.sample.mybatis.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sskim
 */
@Getter
@Setter
@ToString
public class UserVO {

    private Long id;
    private String name;
    private UserType type;

}

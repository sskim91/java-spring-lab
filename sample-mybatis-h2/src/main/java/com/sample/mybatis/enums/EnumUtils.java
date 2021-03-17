package com.sample.mybatis.enums;

import java.util.EnumSet;

/**
 * @author sskim
 */
public class EnumUtils {

    public static <T extends Enum<T> & CodeEnum> T getCodeEnum(Class<T> enumClass, String code) {
        return EnumSet.allOf(enumClass)
                .stream()
                .filter(type -> type.getCode().equals(code))
                .findFirst()
                .orElseGet(null);
    }
}

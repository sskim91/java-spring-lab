package com.sample.mybatis.enums;

import org.apache.ibatis.type.MappedTypes;

/**
 * @author sskim
 */
public enum UserType implements CodeEnum{

    ADMIN("USER000"),
    USER("USER001"),
    GUEST("USER002");

    private String code;

    UserType(String code) {
        this.code = code;
    }

    @MappedTypes(UserType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<UserType> {
        public TypeHandler(Class<UserType> type) {
            super(type);
        }
    }

    @Override
    public String getCode() {
        return code;
    }
}

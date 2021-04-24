package com.sample.mybatis.enums;

import org.apache.ibatis.type.MappedTypes;

/**
 * @author sskim
 */
public enum PaymentType implements CodeEnum {
    CASH("000", "현금"),
    CARD("111", "카드");

    private final String code;
    private final String viewName;

    PaymentType(String code, String viewName) {
        this.code = code;
        this.viewName = viewName;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getViewName() {
        return viewName;
    }

    @MappedTypes(PaymentType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<PaymentType> {
        public TypeHandler() {
            super(PaymentType.class);
        }
    }
}

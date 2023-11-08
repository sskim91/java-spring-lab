package com.sample.mybatis.enums;

import org.apache.ibatis.type.MappedTypes;

/**
 * @author sskim
 */
public enum BoardType implements CodeEnum{
    FREE("1", "자유게시판"),
    NOTICE("2", "공지사항"),
    FAQ("3", "자주묻는게시판")
    ;

    private final String code;
    private final String viewName;

    BoardType(String code, String viewName) {
        this.code = code;
        this.viewName = viewName;
    }

    @MappedTypes(BoardType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<BoardType> {
        public TypeHandler() {
            super(BoardType.class);
        }
    }

    @Override
    public String getCode() {//디비에 저장할때 사용
        return code;
    }

    public String getViewName() {
        return viewName;
    }

}

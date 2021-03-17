package com.sample.mybatis;

import com.sample.mybatis.enums.BoardType;
import com.sample.mybatis.enums.EnumUtils;

/**
 * @author sskim
 */
public class MainApp {
    public static void main(String[] args) {
        //Enum 확인
        System.out.println(BoardType.FREE.name());

        //getter
        System.out.println(BoardType.FREE.getViewName());
        System.out.println(BoardType.FREE.getCode());

        //순서 FREE, NOTICE, FAQ...  0번째 1번째 2번째
        System.out.println(BoardType.FREE.ordinal());

        BoardType[] values = BoardType.values();
        for (BoardType value : values) {
            System.out.println("value = " + value);
        }

        System.out.println(EnumUtils.getCodeEnum(BoardType.class, "1"));
    }
}

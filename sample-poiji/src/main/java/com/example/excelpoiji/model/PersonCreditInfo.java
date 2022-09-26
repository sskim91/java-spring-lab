package com.example.excelpoiji.model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelCellRange;
import lombok.Getter;
import lombok.ToString;

/**
 * @author sskim
 */
@ToString
@Getter
public class PersonCreditInfo {
    @ExcelCellName("No.")
    private Integer no;

    @ExcelCellRange
    private PersonInfo personInfo;

    @ExcelCellRange
    private CardInfo cardInfo;

    @ToString
    public static class PersonInfo {
        @ExcelCellName("Name")
        private String name;
        @ExcelCellName("Age")
        private Integer age;
        @ExcelCellName("City")
        private String city;
        @ExcelCellName("State")
        private String state;
        @ExcelCellName("Zip Code")
        private String zipCode;
    }

    @ToString
    public static class CardInfo {
        @ExcelCellName("Card Type")
        private String type;
        @ExcelCellName("Last 4 Digits")
        private String last4Digits;
        @ExcelCellName("Expiration Date")
        private String expirationDate;
    }
}

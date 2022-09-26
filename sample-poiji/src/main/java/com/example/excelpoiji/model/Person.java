package com.example.excelpoiji.model;

import com.poiji.annotation.ExcelCellName;
import lombok.ToString;

/**
 * @author sskim
 */
@ToString
public class Person {

    @ExcelCellName("Name")
    protected String name;

    @ExcelCellName("Address")
    protected String address;

    @ExcelCellName("Age")
    protected int age;

    @ExcelCellName("Email")
    protected String email;

}

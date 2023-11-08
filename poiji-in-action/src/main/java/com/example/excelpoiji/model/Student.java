package com.example.excelpoiji.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelSheet;
import lombok.ToString;

/**
 * @author sskim
 */
@ToString
@ExcelSheet("Sheet2")
public class Student {
    @ExcelCell(0)
    private String name;

    @ExcelCell(1)
    private String id;

    @ExcelCell(2)
    private String phone;
}

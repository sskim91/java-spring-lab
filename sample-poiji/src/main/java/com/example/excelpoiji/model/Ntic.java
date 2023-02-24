package com.example.excelpoiji.model;

import com.poiji.annotation.ExcelCell;
import lombok.Getter;
import lombok.ToString;

/**
 * @author sskim
 */
@ToString
@Getter
public class Ntic {

    @ExcelCell(2)
    private String PASSWORD;
}

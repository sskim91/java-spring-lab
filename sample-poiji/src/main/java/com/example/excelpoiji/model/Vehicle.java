package com.example.excelpoiji.model;

import com.poiji.annotation.ExcelCell;

/**
 * @author sskim
 */
public abstract class Vehicle {
    @ExcelCell(0)
    protected String name;

    @ExcelCell(1)
    protected int year;

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

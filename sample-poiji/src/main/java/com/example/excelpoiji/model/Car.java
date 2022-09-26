package com.example.excelpoiji.model;

import com.poiji.annotation.ExcelCell;

/**
 * @author sskim
 */
public class Car extends Vehicle {
    @ExcelCell(2)
    private int nOfSeats;

    @Override
    public String toString() {
        return "Car{" +
                "nOfSeats=" + nOfSeats +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

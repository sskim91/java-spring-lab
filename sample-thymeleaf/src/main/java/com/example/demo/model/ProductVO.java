package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author sskim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVO {
    private String name;
    private int price;
    private Date regDate;
}

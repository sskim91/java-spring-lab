package model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author sskim
 */
@Data
@Builder
public class ProductVO {
    private String description;
    private int price;
    private Date availableFrom;
}

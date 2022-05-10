package groupingby;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sskim
 */
@Data
@AllArgsConstructor
public class Order {
    private String itemName;     //주문아이템 이름
    private Integer amount;      //주문 금액
    private OrderType orderType; //주문 타입
    private String orderBy;      //주문자 이름
}

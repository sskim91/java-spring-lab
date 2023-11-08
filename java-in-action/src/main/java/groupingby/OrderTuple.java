package groupingby;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author sskim
 */
@Builder
@AllArgsConstructor
public class OrderTuple {
    private String itemName;
    private OrderType orderType;
}

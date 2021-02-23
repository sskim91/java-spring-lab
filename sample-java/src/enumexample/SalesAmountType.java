package enumexample;

import java.util.function.Function;

/**
 * @author sskim
 */
public enum SalesAmountType {

    ORIGINAL_AMOUNT("원금액", amount -> amount),
    SUPPLY_AMOUNT("공급가액", amount -> Math.round(amount.doubleValue() * 10 / 11)),
    VAT_AMOUNT("부가세액", amount -> Math.round(amount.doubleValue()) / 11),
    NOT_USED("사용안함", amount -> 0L);

    private String viewName;
    private Function<Long, Long> expression;

    SalesAmountType(String viewName, Function<Long, Long> expression) {
        this.viewName = viewName;
        this.expression = expression;
    }

    public Long calculate(long amount) {
        return expression.apply(amount);
    }

    public String getViewName() {
        return viewName;
    }
}

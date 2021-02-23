package enumexample;

import java.util.Arrays;

/**
 * @author sskim
 */
public enum PaymentGroup {
    //결제수단들을 그룹화
    CASH("현금", new PaymentOption[]{
            PaymentOption.BANK_TRANSFER, PaymentOption.DEPOSITLESS, PaymentOption.FIELD_PAYMENT, PaymentOption.TOSS
    }),
    PG("결제대행사", new PaymentOption[]{
            PaymentOption.MOBILE, PaymentOption.CREDIT_CARD, PaymentOption.SIMPLE_PAY
    }),
    ETC("기타", new PaymentOption[]{
            PaymentOption.POINT, PaymentOption.COUPON
    }),
    EMPTY("없음", new PaymentOption[]{
            PaymentOption.POINT, PaymentOption.COUPON
    });

    private String viewName;
    private PaymentOption[] containPayment;

    PaymentGroup(String viewName, PaymentOption[] containPayment) {
        this.viewName = viewName;
        this.containPayment = containPayment;
    }

    public static PaymentGroup findGroup(PaymentOption searchTarget) {
        return Arrays.stream(PaymentGroup.values())
                .filter(group -> hasPaymentOption(group, searchTarget))
                .findAny()
                .orElse(PaymentGroup.EMPTY);
    }

    public static boolean hasPaymentOption(PaymentGroup from, PaymentOption searchTarget) {
        return Arrays.stream(from.containPayment)
                .anyMatch(containPay -> containPay == searchTarget);
    }

    public String getViewName() {
        return viewName;
    }
}

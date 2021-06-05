package enumLambdaTest;

import enumexample.PaymentGroup;
import enumexample.PaymentOption;
import enumexample.SalesAmountType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sskim
 */
public class EnumLambdaTests {
    
    @Test
    @DisplayName("매출별 타입계산")
    void amountTest() throws Exception{
        //given
        long txAmount = 10000L;
        //then
        long originAmount = SalesAmountType.ORIGINAL_AMOUNT.calculate(txAmount);
        assertThat(originAmount).isEqualTo(10000L);

        long supplyAmount = SalesAmountType.SUPPLY_AMOUNT.calculate(txAmount);
        assertThat(supplyAmount).isEqualTo(9091L);

        long vatAmount = SalesAmountType.VAT_AMOUNT.calculate(txAmount);
        assertThat(vatAmount).isEqualTo(909L);

        long notUsed = SalesAmountType.NOT_USED.calculate(txAmount);
        assertThat(notUsed).isEqualTo(0L);
    }

    @Test
    @DisplayName("결제그룹구분")
    void paymentGroupTes() throws Exception{
        //given
        PaymentOption toss = PaymentOption.TOSS;
        PaymentOption simplePay = PaymentOption.SIMPLE_PAY;
        PaymentOption point = PaymentOption.POINT;

        //then
        PaymentGroup tossGroup = PaymentGroup.findGroup(toss);
        PaymentGroup simplePayGroup = PaymentGroup.findGroup(simplePay);
        PaymentGroup pointGroup = PaymentGroup.findGroup(point);

        assertThat(tossGroup.getViewName()).isEqualTo("현금");
        assertThat(simplePayGroup.getViewName()).isEqualTo("결제대행사");
        assertThat(pointGroup.getViewName()).isEqualTo("기타");
    }
}

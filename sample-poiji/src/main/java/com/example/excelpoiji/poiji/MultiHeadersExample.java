package com.example.excelpoiji.poiji;

import com.example.excelpoiji.model.PersonCreditInfo;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

/**
 * @author sskim
 */
public class MultiHeadersExample {
    public static void main(String[] args) throws Exception {

        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "test-multi-headers.xlsx");
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().headerCount(2).build();
        List<PersonCreditInfo> actualPersonalCredits = Poiji.fromExcel(file, PersonCreditInfo.class, options);

        actualPersonalCredits.forEach(System.out::println);

        PersonCreditInfo personCreditInfo1 = actualPersonalCredits.get(0);
        PersonCreditInfo.PersonInfo expectedPerson1 = personCreditInfo1.getPersonInfo();
        PersonCreditInfo.CardInfo expectedCard1 = personCreditInfo1.getCardInfo();

        System.out.println("expectedPerson1 = " + expectedPerson1);
        System.out.println("expectedCard1 = " + expectedCard1);
    }
}

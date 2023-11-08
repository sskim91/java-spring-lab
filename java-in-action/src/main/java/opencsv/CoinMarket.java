package opencsv;

import lombok.*;

/**
 * @author sskim
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoinMarket {

    private String market;
    private String korean_name;
    private String english_name;
}

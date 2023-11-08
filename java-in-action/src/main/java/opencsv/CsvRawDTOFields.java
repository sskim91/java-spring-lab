package opencsv;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author sskim
 */
@Getter
@AllArgsConstructor
public enum CsvRawDTOFields {
    MARKET("market"),
    KOREAN_NAME("korean_name"),
    ENGLISH_NAME("english_name");

    private final String fieldName;

    public static String[] getFieldNameArrays() {
        return Arrays.stream(CsvRawDTOFields.values())
                .map(CsvRawDTOFields::getFieldName)
                .toArray(String[]::new);
    }
}

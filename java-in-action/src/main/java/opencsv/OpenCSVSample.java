package opencsv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.stream.Collectors.toList;

/**
 * @author sskim
 */
public class OpenCSVSample {

    private static final String SAMPLE_CSV_FILE = "coin.csv";
    private static final String SAMPLE_TSV_FILE = "coin.tsv";
    private static final String SAMPLE_JSON_FILE = "coin.json";

    public static void main(String[] args) throws IOException, URISyntaxException {

//        List<String> strings = Files.readAllLines(Paths.get(OpenCSVSample.class.getClassLoader().getResource("coin.tsv").toURI()));
//        System.out.println(strings);

        ClassLoader classLoader = OpenCSVSample.class.getClassLoader();
        File file = new File(classLoader.getResource(SAMPLE_TSV_FILE).getFile());

        try (Reader bufferedReader = Files.newBufferedReader(Paths.get(file.toURI()))) {

            ColumnPositionMappingStrategy<CoinMarket> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(CoinMarket.class);
//            String[] fieldsToBindTo = {"market", "korean_name", "english_name"};
            strategy.setColumnMapping(CsvRawDTOFields.getFieldNameArrays());

            CsvToBean<CoinMarket> csvToBean = new CsvToBeanBuilder<CoinMarket>(bufferedReader)
                    .withSeparator('\t')
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .build();

            csvToBean.stream()
                    .collect(toList())
                    .forEach(System.out::println);

        }
    }
}

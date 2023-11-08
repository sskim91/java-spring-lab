package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sskim on 2021/06/09
 * Github : http://github.com/sskim91
 */
public class JsoupSample02 {
    public static void main(String[] args) {
        Document document;
        try {
            document = Jsoup.connect("https://www.namgarambooks.co.kr/").get();
            Elements elements = (Elements) document.select("#ttItem1434785977 .tt-wrap-item li div a img");
            // 1. 이미지 파일 경로 | 도서 제목 | 이미지 확장자
            List<String> list =
                    elements.stream()
                            .map(element -> {
                                String path = element.attr("src");
                                String ext = path.split("\\.")[(path.split("\\.").length - 1)];
                                //4자 이하는 확장자가 아님, 확장자가 없으면 jpg로 처리
                                ext = (ext.length() > 4 || "".contentEquals(ext)) ? "jpg" : ext;
                                return element.attr("src") + "|" + element.attr("alt") + "|" + ext;
                            })
                            .collect(Collectors.toList());
            list.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

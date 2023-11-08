package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/**
 * Created by sskim on 2021/06/08
 * Github : http://github.com/sskim91
 */
public class JsoupSample01 {
    public static void main(String[] args) throws Exception{
        Document document;
        try {
            document = Jsoup.connect("https://www.namgarambooks.co.kr/category/출간 도서 소개").get();
            Elements elements = (Elements) document.select("#container #content #searchList ol li a");
            elements.stream()
                    .forEach(name -> System.out.println(name.text()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

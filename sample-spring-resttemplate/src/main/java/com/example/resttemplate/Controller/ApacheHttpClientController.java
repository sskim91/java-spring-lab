package com.example.resttemplate.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author sskim
 */
@RestController
public class ApacheHttpClientController {

    @GetMapping("apachehttpclient")
    public ResponseEntity apacheHttpClient() {

        ObjectMapper objectMapper = new ObjectMapper();
        Object objValue = null;

        try {
            URI uri = new URI("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json");
            uri = new URIBuilder(uri)
                    .addParameter("key", "799f23355d82c9c14f5e42bbf848130b")
                    .addParameter("targetDt", "20210201")
                    .build();

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setMaxConnTotal(100)
                    .setMaxConnPerRoute(100)
                    .build();

            HttpResponse httpResponse = httpClient.execute(new HttpGet(uri));
            HttpEntity entity = httpResponse.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println("content = " + content);
            objValue = objectMapper.readValue(content, Object.class);
            System.out.println("objValue = " + objValue);

        } catch (Exception e) {

        }

        return ResponseEntity.ok(objValue);
    }
}

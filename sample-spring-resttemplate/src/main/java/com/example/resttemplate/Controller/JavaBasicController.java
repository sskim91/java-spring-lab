package com.example.resttemplate.Controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author sskim
 */
@RestController
public class JavaBasicController {

    @GetMapping("onlyjavahttp")
    public ResponseEntity<Object> onlyJavaHttp(){

        StringBuilder stringBuilder = new StringBuilder();
        JSONObject jsonObject = new JSONObject();

        try {

            String urlStr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
            urlStr += "?key=799f23355d82c9c14f5e42bbf848130b";
            urlStr += "&targetDt=20210201";
            URL url = new URL(urlStr);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String temp;

            while ((temp = br.readLine()) != null) {
                System.out.println("temp = " + temp);
                stringBuilder.append(temp + "\n");
            }
            httpURLConnection.disconnect();
            br.close();

            JSONParser jsonParser = new JSONParser();
            Object parseObj = jsonParser.parse(stringBuilder.toString());
            jsonObject = (JSONObject) parseObj;

            System.out.println("jsonObject = " + jsonObject);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(jsonObject);
    }
}

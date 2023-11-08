package com.example.resttemplate.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class JSONUtil {

    private JSONUtil(){}

    /**
     * Object Map을 JSONObject로 변환한다.
     *
     * @param map Map<String, Object>.
     * @return String.
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getJSONObjectStringFromObjMap(Map<String, Object> map) {

        JSONObject json = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            json.put(key, value);
        }

        return json;
    }

    /**
     * String Map을 JSONObject로 변환한다.
     *
     * @param map Map<String, Object>.
     * @return String.
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getJSONObjectFromStringMap(Map<String, String> map) {

        JSONObject json = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            json.put(key, value);
        }

        return json;
    }

    /**
     * List<Map>을 json으로 변환한다.
     *
     * @param list List<Map<String, Object>>.
     * @return JSONArray.
     */
    @SuppressWarnings("unchecked")
    public static JSONArray getJsonArrayFromList(List<Map<String, Object>> list) {

        JSONArray jsonArray = new JSONArray();
        for (Map<String, Object> map : list) {
            jsonArray.add(getJSONObjectStringFromObjMap(map));
        }

        return jsonArray;
    }

    /**
     * List<Map>을 jsonString으로 변환한다.
     *
     * @param list List<Map<String, Object>>.
     * @return String.
     */
    @SuppressWarnings("unchecked")
    public static String getJsonStringFromList(List<Map<String, Object>> list) {

        JSONArray jsonArray = new JSONArray();
        for (Map<String, Object> map : list) {
            jsonArray.add(getJSONObjectStringFromObjMap(map));
        }

        return jsonArray.toJSONString();
    }

    /**
     * JsonObject를 Map<String, String>으로 변환한다.
     *
     * @param jsonObj JSONObject.
     * @return String.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMapFromJsonObject(JSONObject jsonObj) {

        Map<String, Object> map = null;

        try {

            map = new ObjectMapper().readValue(jsonObj.toJSONString(), Map.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * JsonArray를 List<Map<String, String>>으로 변환한다.
     *
     * @param jsonArray JSONArray.
     * @return List<Map < String, Object>>.
     */
    public static List<Map<String, Object>> getListMapFromJsonArray(JSONArray jsonArray) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (jsonArray != null) {
            int jsonSize = jsonArray.size();
            for (int i = 0; i < jsonSize; i++) {
                Map<String, Object> map = JSONUtil.getMapFromJsonObject((JSONObject) jsonArray.get(i));
                list.add(map);
            }
        }

        return list;
    }

    /**
     * Json 데이터 보기 좋게 변환.
     *
     * @param json
     * @return
     */
    public static String JsonEnterConvert(String json) {

        if (json == null || json.length() < 2)
            return json;

        final int len = json.length();
        final StringBuilder sb = new StringBuilder();
        char c;
        String tab = "";
        boolean beginEnd = true;
        for (int i = 0; i < len; i++) {
            c = json.charAt(i);
            switch (c) {
                case '{':
                case '[': {
                    sb.append(c);
                    if (beginEnd) {
                        tab += "\t";
                        sb.append("\n");
                        sb.append(tab);
                    }
                    break;
                }
                case '}':
                case ']': {
                    if (beginEnd) {
                        tab = tab.substring(0, tab.length() - 1);
                        sb.append("\n");
                        sb.append(tab);
                    }
                    sb.append(c);
                    break;
                }
                case '"': {
                    if (json.charAt(i - 1) != '\\')
                        beginEnd = !beginEnd;
                    sb.append(c);
                    break;
                }
                case ',': {
                    sb.append(c);
                    if (beginEnd) {
                        sb.append("\n");
                        sb.append(tab);
                    }
                    break;
                }
                default: {
                    sb.append(c);
                }
            }// switch end

        }
        if (sb.length() > 0)
            sb.insert(0, '\n');
        return sb.toString();
    }

    /**
     * java bean 객체에서 field name 과 field value 를 취하여 json 객체로 변환한다
     *
     * @param obj
     * @return JSONObject
     * @throws IllegalAccessException
     */
    public static JSONObject beanToJSONObject(Object obj) throws IllegalAccessException {

        Field[] fa = obj.getClass().getDeclaredFields();

        JSONObject jsonObj = new JSONObject();
        for (int i = 0; i < fa.length; i++) {
            Field f = fa[i];
            String fn = f.getName();
            jsonObj.put(fn, f.get(obj));
        }

        return jsonObj;
    }
}
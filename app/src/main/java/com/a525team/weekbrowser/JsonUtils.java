package com.a525team.weekbrowser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JsonUtils {

    // -------------------------
    // Серіалізація об'єктів у JSON
    // -------------------------
    public static String toJson(Object obj) {
        if (obj == null) return "null";

        try {
            if (obj instanceof Map) {
                return mapToJson((Map<?, ?>) obj).toString();
            } else if (obj instanceof List) {
                return listToJson((List<?>) obj).toString();
            } else if (obj instanceof String) {
                return "\"" + escapeString((String) obj) + "\"";
            } else if (obj instanceof Number || obj instanceof Boolean) {
                return obj.toString();
            } else {
                return "\"" + escapeString(obj.toString()) + "\"";
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return "null";
        }
    }

    private static JSONObject mapToJson(Map<?, ?> map) throws JSONException {
        JSONObject json = new JSONObject();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            String key = String.valueOf(entry.getKey());
            Object value = entry.getValue();
            if (value instanceof Map) {
                json.put(key, mapToJson((Map<?, ?>) value));
            } else if (value instanceof List) {
                json.put(key, listToJson((List<?>) value));
            } else {
                json.put(key, value);
            }
        }
        return json;
    }

    private static JSONArray listToJson(List<?> list) throws JSONException {
        JSONArray arr = new JSONArray();
        for (Object item : list) {
            if (item instanceof Map) {
                arr.put(mapToJson((Map<?, ?>) item));
            } else if (item instanceof List) {
                arr.put(listToJson((List<?>) item));
            } else {
                arr.put(item);
            }
        }
        return arr;
    }

    private static String escapeString(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    // -------------------------
    // Десеріалізація у List/Map
    // -------------------------
    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String jsonStr, Class<T> type) throws JSONException {
        if (jsonStr == null || jsonStr.equals("null") || jsonStr.isEmpty()) {
            if (List.class.isAssignableFrom(type)) return (T) new ArrayList<>();
            if (Map.class.isAssignableFrom(type)) return (T) new HashMap<>();
            return null;
        }

        if (List.class.isAssignableFrom(type)) {
            return (T) jsonToList(new JSONArray(jsonStr));
        } else if (Map.class.isAssignableFrom(type)) {
            return (T) jsonToMap(new JSONObject(jsonStr));
        } else if (String.class.isAssignableFrom(type)) {
            return (T) jsonStr;
        } else {
            return (T) jsonStr;
        }
    }

    private static List<Object> jsonToList(JSONArray arr) throws JSONException {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            Object item = arr.get(i);
            if (item instanceof JSONObject) {
                list.add(jsonToMap((JSONObject) item));
            } else if (item instanceof JSONArray) {
                list.add(jsonToList((JSONArray) item));
            } else {
                list.add(item);
            }
        }
        return list;
    }

    private static Map<String, Object> jsonToMap(JSONObject obj) throws JSONException {
        Map<String, Object> map = new HashMap<>();
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = obj.get(key);
            if (value instanceof JSONObject) {
                map.put(key, jsonToMap((JSONObject) value));
            } else if (value instanceof JSONArray) {
                map.put(key, jsonToList((JSONArray) value));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }

    // -------------------------
    // Спеціальні методи для твоїх типів
    // -------------------------
    public static ArrayList<HashMap<String,Object>> SO(String json) throws JSONException {
        List<?> tmp = fromJson(json, List.class);
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        for (Object o : tmp) result.add((HashMap<String,Object>) o);
        return result;
    }

    public static ArrayList<String> S(String json) throws JSONException {
        List<?> tmp = fromJson(json, List.class);
        ArrayList<String> result = new ArrayList<>();
        for (Object o : tmp) result.add((String) o);
        return result;
    }
    
    public static HashMap<String,Object> M(String json) throws JSONException {
    Object tmp = fromJson(json, Map.class); // fromJson повертає Map<String,Object>
    return (HashMap<String,Object>) tmp;
}

}

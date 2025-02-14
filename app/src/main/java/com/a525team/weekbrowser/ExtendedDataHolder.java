package com.a525team.weekbrowser;

import java.util.HashMap;
import java.util.Map;

public class ExtendedDataHolder {
    private static ExtendedDataHolder instance;
    private Map<String, String> dataMap;

    private ExtendedDataHolder() {
        dataMap = new HashMap<>();
    }

    public static synchronized ExtendedDataHolder getInstance() {
        if (instance == null) {
            instance = new ExtendedDataHolder();
        }
        return instance;
    }

    public void setData(String key, String value) {
        dataMap.put(key, value);
    }

    public String getData(String key) {
        return dataMap.get(key);
    }

    public void removeData(String key) {
        dataMap.remove(key);
    }

    public boolean containsKey(String key) {
        return dataMap.containsKey(key);
    }

    public void clearAllData() {
        dataMap.clear();
    }
}

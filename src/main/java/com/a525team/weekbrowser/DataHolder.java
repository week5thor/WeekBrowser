package com.a525team.weekbrowser;

public class DataHolder {
    private static DataHolder instance;
    private String data;

    private DataHolder() {
        // Приватний конструктор для запобігання створення нових екземплярів
    }

    public static synchronized DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

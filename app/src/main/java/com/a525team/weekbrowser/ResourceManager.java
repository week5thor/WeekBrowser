package com.a525team.weekbrowser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceManager {
    private static final ResourceManager instance = new ResourceManager();
    
    // Використовуємо String як ключ, щоб уникнути витоків пам'яті, 
    // якщо як Tag передається складний об'єкт
    private final Map<Object, List<Map<String, Object>>> tabResourcesMap = new ConcurrentHashMap<>();
    private final Map<Object, String> tabSslErrorsMap = new ConcurrentHashMap<>();
    private final Map<Object, Boolean> tabBlackAdMap = new ConcurrentHashMap<>();

    private ResourceManager() {}

    public static ResourceManager getInstance() {
        return instance;
    }

    public List<Map<String, Object>> getOrCreateResourcesForTab(Object tag) {
        if (tag == null) return null;
        
        List<Map<String, Object>> resources = tabResourcesMap.get(tag);
        if (resources == null) {
            // Використовуємо thread-safe список відразу
            resources = Collections.synchronizedList(new ArrayList<Map<String, Object>>());
            tabResourcesMap.put(tag, resources);
        }
        return resources;
    }

    public void clearResourcesForTab(Object tag) {
        if (tag == null) return;
        
        List<Map<String, Object>> resources = tabResourcesMap.get(tag);
        if (resources != null) {
            // Очищення списку атомарне для synchronizedList
            resources.clear();
        }
    }

    public void setSslErrorForTab(Object tag, String errorMessage) {
    if (tag == null) return;
    // ПРИМУСОВО: Робимо рядок і відрізаємо пробіли, якщо вони випадково є
    String safeKey = String.valueOf(tag).trim(); 
    
    if (errorMessage == null) {
        tabSslErrorsMap.remove(safeKey);
    } else {
        tabSslErrorsMap.put(safeKey, errorMessage);
    }
}

public String getSslErrorForTab(Object tag) {
    if (tag == null) return null;
    // Шукаємо ТІЛЬКИ за примусовим рядком
    String safeKey = String.valueOf(tag).trim(); 
    return tabSslErrorsMap.get(safeKey);
}

    public void clearSslErrorForTab(Object tag) {
        String safeKey = String.valueOf(tag).trim();
        if (tag != null) {
            tabSslErrorsMap.remove(safeKey);
        }
    }
    
    
    
    public void setAdForTab(Object tag, boolean need) {
    if (tag == null) return;
    // ПРИМУСОВО: Робимо рядок і відрізаємо пробіли, якщо вони випадково є
    String safeKey = String.valueOf(tag).trim(); 
    
    tabBlackAdMap.put(safeKey, need);
}

public boolean getAdForTab(Object tag) {
    if (tag == null)
    throw new RuntimeException("No tag for ad blocking!");
    //return false;
    // Шукаємо ТІЛЬКИ за примусовим рядком
    String safeKey = String.valueOf(tag).trim(); 
    return tabBlackAdMap.get(safeKey);
}

    public void clearAdForTab(Object tag) {
        String safeKey = String.valueOf(tag).trim();
        if (tag != null) {
            tabBlackAdMap.remove(safeKey);
        }
    }



    public void removeTab(Object tag) {
        if (tag == null) return;
        tabResourcesMap.remove(tag);
        tabSslErrorsMap.remove(tag);
    }
}












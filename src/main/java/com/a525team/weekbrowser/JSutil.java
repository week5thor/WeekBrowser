package com.a525team.weekbrowser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSutil {

    // Метод для перетворення кольору з формату AARRGGBB у RRGGBBAA
    private static String convertColorFormat(String color) {
        if (color == null || color.length() != 8) {
            throw new IllegalArgumentException("Invalid color format" + color);
        }
        // AARRGGBB -> RRGGBBAA
        return "#" + color.substring(2) + color.substring(0, 2);
    }

    // Метод для генерації градієнту на основі параметрів
private static String generateGradient(String colors, int gradientType, int segments, int sharpness) {
    // Переконаємося, що рядок кольорів ділиться на підрядки довжиною рівно 8 символів
    if (colors.length() % 8 != 0) {
        throw new IllegalArgumentException("Color string length is invalid: " + colors);
    }

    // Створюємо масив кольорів, де кожен елемент має 8 символів (формат AARRGGBB)
    String[] colorArray = new String[colors.length() / 8];
    for (int i = 0; i < colorArray.length; i++) {
        colorArray[i] = colors.substring(i * 8, (i + 1) * 8);
    }

    StringBuilder gradient = new StringBuilder();

    // Кількість кольорів в градієнті для одного сегмента
    int colorsPerSegment = Math.max(1, colorArray.length / segments);

    // Формування градієнту
    for (int i = 0; i < segments; i++) {
        int startIndex = i * colorsPerSegment % colorArray.length;
        int endIndex = Math.min(startIndex + colorsPerSegment, colorArray.length);

        // Додавання кольорів до сегмента з урахуванням різкості
        for (int j = 0; j < sharpness; j++) {
            for (int k = startIndex; k < endIndex; k++) {
                gradient.append(convertColorFormat(colorArray[k])).append(", ");
            }
        }
    }

    // Видалення зайвої коми та пробілу в кінці
    if (gradient.length() > 2) {
        gradient.setLength(gradient.length() - 2);
    }

    // Повернення градієнту у відповідному форматі
    switch (gradientType) {
        case 0: return "linear-gradient(to bottom, " + gradient.toString() + ")";
        case 1: return "linear-gradient(to right, " + gradient.toString() + ")";
        case 2: return "linear-gradient(to bottom right, " + gradient.toString() + ")";
        case 3: return "linear-gradient(to top right, " + gradient.toString() + ")";
        case 4: return "radial-gradient(circle at center, " + gradient.toString() + ")";
        case 5: return "conic-gradient(" + gradient.toString() + ")";
        default: throw new IllegalArgumentException("Invalid gradient type");
    }
}






    // Метод для заміни інструкцій у JavaScript-коді
    public static String replaceInstruction(String jsCode) {
        // Перевірка на null значення
        ExtendedDataHolder dataHolder = ExtendedDataHolder.getInstance();
        if (jsCode == null || dataHolder == null) {
            throw new IllegalArgumentException("JavaScript code or data holder is null");
        }

        // Заміна шаблонних інструкцій
        jsCode = jsCode
                .replace("$bggrad$", generateGradient(
                    dataHolder.getData("bg"),
                    Integer.parseInt(dataHolder.getData("bgrad")),
                    Integer.parseInt(dataHolder.getData("bstrcou")),
                    Integer.parseInt(dataHolder.getData("btm"))
                ))
                .replace("$buttongrad$", generateGradient(
                    dataHolder.getData("bbg"),
                    Integer.parseInt(dataHolder.getData("grad")),
                    Integer.parseInt(dataHolder.getData("strcou")),
                    Integer.parseInt(dataHolder.getData("tm"))
                ))
                .replace("$redgrad$", generateGradient(
                    dataHolder.getData("rbg"),
                    Integer.parseInt(dataHolder.getData("rgrad")),
                    Integer.parseInt(dataHolder.getData("rstrcou")),
                    Integer.parseInt(dataHolder.getData("rtm"))
                ))
                .replace("$coltext$", convertColorFormat(dataHolder.getData("t")))
                .replace("$colfield$", convertColorFormat(dataHolder.getData("tf")))
                .replace("$coladd$", convertColorFormat(dataHolder.getData("add")))
                .replace("$colhint$", convertColorFormat(dataHolder.getData("h")))
                .replace("$colcomp$", convertColorFormat(dataHolder.getData("cb")))
                .replace("$coltrack$", convertColorFormat(dataHolder.getData("tpc")))
                .replace("$colthumb$", convertColorFormat(dataHolder.getData("tc")))
                .replace("$buttonround$", dataHolder.getData("rou")) // Заокруглення кнопок
                .replace("$redround$", dataHolder.getData("rrou")) // Заокруглення кнопок у фокусі
                .replace("$colbtxt$", convertColorFormat(dataHolder.getData("bt"))) // Колір тексту кнопок
                .replace("$colrbtxt$", convertColorFormat(dataHolder.getData("rbt"))); // Колір тексту кнопок у фокусі

jsCode = minifyAndClean(jsCode);
        return jsCode;
    }

    // Метод для видалення коментарів та пробілів з JavaScript-коду
    public static String minifyAndClean(String jsCode) {
        // Видалення коментарів
//        jsCode = jsCode.replaceAll("//.*|/\\*(.|\\R)*?\\*/", "");

        // Видалення непотрібних пробілів та символів нового рядка
        jsCode = jsCode.replaceAll("\\s+", " ").trim();

        return jsCode;
    }
}

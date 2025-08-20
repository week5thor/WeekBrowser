package com.a525team.weekbrowser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Метод для зчитування N-ого рядка з файлу
    public static String readLinesFromFile(String filePath, int lineNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (currentLine == lineNumber) {
                    return line;
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Додайте ваше логування тут
        }
        return null; // Повертає null, якщо лінія не знайдена або виникла помилка
    }

    // Метод для підрахунку кількості рядків у файлі
    public static int getFileLines(String filePath) {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Додайте ваше логування тут
        }
        return lineCount;
    }

    // Метод для видалення рядка під певним номером
    public static void removeLineFromFile(String filePath, int lineNumber) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 0;
            while ((line = br.readLine()) != null) {
                if (currentLine != lineNumber) {
                    lines.add(line);
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace(); // Додайте ваше логування тут
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Додайте ваше логування тут
        }
    }
}

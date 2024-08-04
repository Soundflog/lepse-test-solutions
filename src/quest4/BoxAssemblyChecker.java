package quest4;

import java.io.*;
import java.util.*;

public class BoxAssemblyChecker {

    public static void main(String[] args) {
        // Тестовые файлы
        String[] testFiles = {
                "src/quest4/sheets1.txt",
                "src/quest4/sheets2.txt",
                "src/quest4/sheets3.txt",
                "src/quest4/sheets4.txt",
                "src/quest4/sheets5.txt"
        };

        for (String testFile : testFiles) {
            System.out.println("Тестовый файл: " + testFile);
            List<int[]> sheets = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        int[] dimensions = new int[2];
                        dimensions[0] = Integer.parseInt(parts[0]);
                        dimensions[1] = Integer.parseInt(parts[1]);
                        sheets.add(dimensions);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }

            if (sheets.size() != 6) {
                System.out.println("Невозможно, поскольку размер не 6\n");
                continue;
            }

            System.out.println(canFormBox(sheets) ? "Возможно" : "Невозможно");
            System.out.println();
        }
    }

    private static boolean canFormBox(List<int[]> sheets) {
        Map<String, Integer> dimensionCount = new HashMap<>();
        for (int[] sheet : sheets) {
            int length = sheet[0];
            int width = sheet[1];
            String key1 = length + "x" + width;
            String key2 = width + "x" + length;

            // Используем только один ключ, чтобы избежать дублирования
            String key = length < width ? key1 : key2;
            dimensionCount.put(key, dimensionCount.getOrDefault(key, 0) + 1);
        }

        // Проверяем, что каждая пара размеров встречается ровно дважды
        for (int count : dimensionCount.values()) {
            if (count != 2) {
                return false;
            }
        }

        return dimensionCount.size() == 3;
    }
}

package GLOSSARY;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Croaker
 * @version 1.0.0
 * @project Final
 * @class Main
 * @since 19.04.2021 - 18.06
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        String text1 = new String(Files.readAllBytes(Paths.get("harry.txt")));
        String text = text1.replaceAll("[^A-Za-z ']", "");
        String[] words = text.split(" +");

        Map<String, Integer> wordMap = new HashMap<>();
        Integer value = 0;
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                value = wordMap.get(word);
                wordMap.put(word, value + 1);
            }
        }

        Map<String, Integer> sorted = new LinkedHashMap<>();
        wordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sorted.put(entry.getKey(), entry.getValue()));
        sorted.entrySet().stream().limit(20).forEach(System.out::println);

        StringBuilder sorted20 = new StringBuilder("_____________Sorted 20_____________\n");
        int counter = 0;
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            counter++;
            sorted20.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            if (counter == 20) break;
        }

        String fileOutput = "Distincts" + ".txt";
        Files.writeString(Paths.get(fileOutput), sorted20.toString());
    }
}


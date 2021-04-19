package GLOSSARY;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author Croaker
 * @version 1.0.0
 * @project Final
 * @class Main
 * @since 19.04.2021 - 18.06
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("distinctWords.txt");
        String text = new String(Files.readAllBytes(Paths.get("harry.txt")));
        String text1 = text.replaceAll("[^A-Za-z ']", "");

        String[] words = text.split(" ");
        List<String> list = Arrays.stream(words).collect(Collectors.toList());

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
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sorted.put(entry.getKey(),entry.getValue()));
        sorted.entrySet().stream().limit(20).forEach(System.out::println);
    }
}


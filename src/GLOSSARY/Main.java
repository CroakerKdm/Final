package GLOSSARY;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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

        StringBuilder sorted20 = new StringBuilder()
                .append("Header for final task\n" +
                        "@author Croaker\n" +
                        "@project Final\n" +
                        "20 distinct words by number of occurrence:\n");
        int counter = 0;
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            counter++;
            sorted20.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            if (counter == 20) break;
        }

        List<String> list = Arrays.stream(words).collect(Collectors.toList());
        List<String> properNamesList = list.stream().distinct().filter(entry -> !wordMap.containsKey(entry.toLowerCase()))
                .filter(entry -> Character.isUpperCase(entry.charAt(0))).sorted().collect(Collectors.toList());

        System.out.println("\nSORTED PAIRS");
        sorted.entrySet().stream().limit(20).forEach(System.out::println);
        String fileOutput = "Distincts" + ".txt";
        Files.writeString(Paths.get(fileOutput), sorted20.toString());

        System.out.println("\nSORTED NAMES");
        System.out.println("Proper names number: " + properNamesList.size());
        properNamesList.stream().limit(20).forEach(System.out::println);

    }
}


/*
        SORTED PAIRS
        the=3313
        to=1845
        and=1807
        a=1578
        of=1242
        Harry=1213
        was=1178
        he=1033
        in=933
        his=896
        it=804
        said=793
        you=735
        had=697
        I=652
        on=617
        at=581
        that=580
        him=495
        He=494

        SORTED NAMES
        Proper names number: 670
        AAAAAAAAAARGH
        AAAARGH
        ALBUS
        ALLEY
        Aaah
        Aargh
        Abbott
        Absolutely
        According
        Adalbert
        Adrian
        Africa
        African
        Agrippa
        Ah
        Aha
        Ahem
        Ahern
        Alas
        Alberic
*/


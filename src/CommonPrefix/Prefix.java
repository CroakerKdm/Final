package CommonPrefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Croaker
 * @version 1.0.0
 * @project Final
 * @class Prefix
 * @since 19.04.2021 - 19.01
 **/

public class Prefix {

    public static String prefix(String[] array) {
        int minLength = Arrays.stream(array).mapToInt(String::length).min().getAsInt();
        List<String> prefix = new ArrayList<>();
        System.out.println(minLength);
        for (int i = minLength; i > 0; i--) {
            int numberOfDigits = i;
            prefix = Arrays.stream(array).map(string -> string.substring(0, numberOfDigits))
                    .distinct().collect(Collectors.toList());
            if (prefix.size() <= 1) {
                break;
            }
        }
        return prefix.get(0);
    }

    public static void main(String[] args) {
        String[] array = {"abc", "abcd", "abfce", "abcac"};

        System.out.println(prefix(array));  // ab

        String[] array2 = {"abc", "abcd", "abce", "abcac"};

        System.out.println(prefix(array2)); //abc
    }
}

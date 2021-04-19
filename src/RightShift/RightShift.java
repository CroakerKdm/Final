package RightShift;

import java.util.Arrays;

/**
 * @author Croaker
 * @version 1.0.0
 * @project Final
 * @class RightShift
 * @since 19.04.2021 - 18.40
 **/
public class RightShift {
    public static int[] rightShift(int[] array, int step) {
        for (int i = 0; i < step; i++) {
            int lastElement = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length-1 );
            array[0] = lastElement;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        System.out.println(Arrays.toString(rightShift(array, 1))); // [30, 10, 20]

        int[] array2 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array2, 2))); // [40, 50, 10, 20, 30]

        int[] array3 = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(rightShift(array3, 21))); // [50, 10, 20, 30, 40]
    }
}

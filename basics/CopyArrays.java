package basics;

import java.util.Arrays;

/**
 * @author Ramesh BG
 *
 */
public class CopyArrays {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] firstArray = { 1, 2, 3, 4, 5, 6, 7 };
        int[] secondArray = new int[firstArray.length - 1];
        Arrays.copyOf(firstArray, 10);
        System.out.println(Arrays.toString(secondArray));
        System.arraycopy(firstArray, 1, secondArray, 0, firstArray.length - 1);
        System.out.println(Arrays.toString(secondArray));
    }
}
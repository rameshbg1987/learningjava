package other;

/**
 * @author Ramesh BG
 *
 */
public class MaxSubArrayBruteForce {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = { 1, -1, 4, 5, -8, -9, 0 };
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum = sum + array[j];
            }
        }
    }
}

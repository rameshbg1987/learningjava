package basics;

/**
 * @author Ramesh BG
 *
 */
public class ArrayMultiDimension {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = new int[3][];
        array[0] = new int[10];
        array[1] = new int[3];
        array[2] = new int[2];
        System.out.println(array[0].length);
        System.out.println(array[1].length);
        System.out.println(array[2].length);
    }
}

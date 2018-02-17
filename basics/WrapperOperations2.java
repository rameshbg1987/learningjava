package basics;

/**
 * @author Ramesh BG
 *
 */
public class WrapperOperations2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Wrappers are immutable so what happens if increment operation is
         * performed on reference variable of Integer ?
         * 
         * UNBOXES value, increments value and creates new Integer(newValue),
         * reference points to new object value.
         */
        Integer a = 10;
        a++;
        System.out.println(a);
    }
}

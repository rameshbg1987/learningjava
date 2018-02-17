package basics;

/**
 * @author Ramesh BG
 *
 */
public class WrapperOperations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Wrappers are immutable
         */

        /**
         * 10 is converted to Integer.valueOf(10)
         */
        Integer a = 10;
        Integer b = 10;

        if (a == b) {
            System.out.println("BOTH ARE EQUAL");
        } else {
            System.out.println("BOTH ARE NOT EQUAL");
        }

        /**
         * 
         * even though 128 is converted to Integer.valueOf(128)
         * caching value ranges from -128 to +127
         * so value +128 is not cached hence new Integer(128) is created when 
         * Integer.valueOf(128) is called which results in two different objects
         * for two calls.
         * 
         */
        Integer c = 128;
        Integer d = 128;

        if (c == d) {
            System.out.println("BOTH ARE EQUAL");
        } else {
            System.out.println("BOTH ARE NOT EQUAL");
        }
    }
}

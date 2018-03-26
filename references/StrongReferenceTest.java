package references;

/**
 * @author Ramesh BG
 *
 */
public class StrongReferenceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * str is reference to String "hello world" which is Strong Reference
         * hence garbage collection cannot happen on this object.
         */
        String str = "hello world";
        System.out.println(str);
    }
}

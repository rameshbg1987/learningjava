package references;

import java.lang.ref.SoftReference;

/**
 * @author Ramesh BG
 *
 */
public class SoftReferenceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SoftClassTest referent = new SoftClassTest();
        SoftReference<SoftClassTest> softReference = new SoftReference<SoftClassTest>(
                referent);
        referent = null;
        System.gc();
        /*
         * softReference object will be claimed only when there is a memory crunch.
         * otherwise following code will run for infinite number of times.
         */
        while (softReference.get() != null) {
            System.out.println(softReference.get() +" Memory value is " + Runtime.getRuntime().freeMemory());
        }
    }
}

class SoftClassTest {

    private int i = 0;

    public String toString() {
        return "This is SoftClassTest Object " + i++;
    }
}
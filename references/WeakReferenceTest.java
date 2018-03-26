package references;

import java.lang.ref.WeakReference;

/**
 * @author Ramesh BG
 *
 */
public class WeakReferenceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Myclass myClass = new Myclass();
        WeakReference<Myclass> weakReference = new WeakReference<Myclass>(
                myClass);
        myClass = null;
        /**
         * myClass is now available in next GC since there are no strong
         * references and only weak references point to myClass object.
         */
        while (true) {
            if (weakReference.get() == null) {
                System.out.println("Out of GC");
                break;
            }
            System.out.println(weakReference.get());
            // System.gc();
        }
    }
}

class Myclass {
    private static int i = 0;

    public String toString() {
        return "This is MyClass Object " + i++;
    }
}

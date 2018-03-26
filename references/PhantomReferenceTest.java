package references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author Ramesh BG
 *
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<PhantomClassTest> referenceQueue = new ReferenceQueue<>();
        /*
         * what is the use of enqueueing in ReferenceQueue ?  
         */
        PhantomReference<PhantomClassTest> phantomReference = new PhantomReference<PhantomClassTest>(
                new PhantomClassTest(), referenceQueue);
        while(!phantomReference.isEnqueued()) {
            System.out.println("NOT ENQUEUED");
        }
        System.out.println("FINALLY ENQUEUED");
        System.out.println(referenceQueue.poll().get());
    }
}

class PhantomClassTest {

    int i = 0;

    @Override
    public String toString() {
        return "This is PhantomClassTest Object " + i++;
    }
}

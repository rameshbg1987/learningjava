package test;

/**
 * @author Ramesh BG
 *
 */
public class ThreadDumpTest {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        synchronized (obj) {
            obj.wait();
        }
    }
}

package threads;
import java.util.concurrent.Semaphore;

/**
 * @author Ramesh BG
 *
 */
public class SemaphorePrintTest {

    private Semaphore semaphore = new Semaphore(1);

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SemaphorePrintTest semaphoreTest = new SemaphorePrintTest();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        semaphoreTest.criticalBlock(String
                                .valueOf(Thread.currentThread().getName()));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }

    private void criticalBlock(String str) throws InterruptedException {
        semaphore.acquire();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello this is " + str);
        /**
         * use System time to check only one thread is active since
         * Semaphore(1) is used.
         */
        System.out.println(stringBuilder.toString() + " Time is "
                + System.currentTimeMillis());
        for (int i = 0; i < 10000; i++)
           System.out.print("hello");
        System.out.println();
        semaphore.release();
    }
}

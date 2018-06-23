package threads;
import java.util.concurrent.CountDownLatch;

/**
 * @author Ramesh BG
 *
 */
public class MyPool {

    private static int NUMBER_OF_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startingGate = new CountDownLatch(1);
        CountDownLatch endingGate = new CountDownLatch(NUMBER_OF_THREADS);
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= NUMBER_OF_THREADS; i++) {
                    try {
                        try {
                            startingGate.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Thread Number " + i);
                    } finally {
                        endingGate.countDown();
                    }
                }
            }
        }).start();

        startingGate.countDown();
        endingGate.await();
    }
}

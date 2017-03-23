package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author Ramesh BG
 *
 */
public class CountDownLatchTest {
    private CountDownLatch countDownLatch = new CountDownLatch(2);

    /**
     * @param args
     */
    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        countDownLatchTest.init();
        System.out.println("main done");
    }

    private void init() {
        createThreads();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createThreads() {
        for (int j = 0; j < 2; j++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 1; i < 10; i++) {
                        System.out.println(i);
                        try {
                            Thread.sleep(new Random().nextInt(500));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //reduce count value here.
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}

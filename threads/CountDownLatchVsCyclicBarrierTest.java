package threads;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ramesh BG
 *
 */
public class CountDownLatchVsCyclicBarrierTest {

    private CountDownLatch countDownLatch;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchVsCyclicBarrierTest countDownLatchVsCyclicBarrierTest = new CountDownLatchVsCyclicBarrierTest();
        countDownLatchVsCyclicBarrierTest.countDownLatchTest();
        /*
         * main thread will be waiting untill countdown set to zero
         */
        countDownLatchVsCyclicBarrierTest.countDownLatch.await();
        System.out.println("this is main method waiting for count down latch");
        countDownLatchVsCyclicBarrierTest.cyclicBarrierTest();
        System.out.println("this is main method for cyclic barrier");
    }

    private void countDownLatchTest() {
        this.countDownLatch = new CountDownLatch(4);
        int i = 1;
        while (i++ <= 4) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(
                            "Thread " + atomicInteger.getAndIncrement());
                    /**
                     * count down will be decremented in other threads.
                     */
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    private void cyclicBarrierTest() {
        int i = 1;
        AtomicInteger atomicInteger = new AtomicInteger(1);
        while (i++ <= 4) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        int andIncrement = atomicInteger.getAndIncrement();
                        System.out.println("this is thread " + andIncrement
                                + " waiting for others");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
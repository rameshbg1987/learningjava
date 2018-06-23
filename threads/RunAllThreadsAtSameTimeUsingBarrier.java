package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Ramesh BG
 *
 */
public class RunAllThreadsAtSameTimeUsingBarrier {

    private static final int MAX_THREADS = 10;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(MAX_THREADS + 1);

    private int i = 0;

    public static void main(String[] args) {
        new RunAllThreadsAtSameTimeUsingBarrier().threadOperation();
    }

    private void threadOperation() {
        for (; i < MAX_THREADS; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int iLocal = i;
                    try {
                        cyclicBarrier.await();
                        System.out.println("This is Thread Task " + iLocal);
                        for (int i = 0; i <100000; i++) {
                            for (int j = 0; j < 100000; j++) {
                                
                            }
                            
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            cyclicBarrier.await();
                        } catch (InterruptedException
                                | BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        long startTime = System.currentTimeMillis();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(
                "Total Time taken by all threads is " + (endTime - startTime));
    }
}
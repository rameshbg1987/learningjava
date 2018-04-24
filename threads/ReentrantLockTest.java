package threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ramesh BG
 * SemaphorePrintTest.java implemented using ReentrantLock
 */
public class ReentrantLockTest {
    
    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        reentrantLockTest.criticalBlock(String
                                .valueOf(Thread.currentThread().getName()));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }

    private void criticalBlock(String str) throws InterruptedException {
        
        try {
            this.reentrantLock.lock();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hello this is " + str);
            /**
             * use System time to check only one thread is active since Semaphore(1)
             * is used.
             */
            System.out.println(stringBuilder.toString() + " Time is "
                    + System.currentTimeMillis());
            for (int i = 0; i < 10000; i++)
                System.out.print("hello");
            System.out.println();
        } finally {
            this.reentrantLock.unlock();
        }
    }
}

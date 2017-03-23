package test;

import threads.CustomReentrantLock;

/**
 * @author Ramesh BG
 *
 */
public class CustomReentrantLockTest {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) {
        try {
            start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */

    public static void start() throws InterruptedException {
        CustomReentrantLock lock = new CustomReentrantLock();
        for (int i = 1; i <= 5; i++) {
            ExtendedThread extendedThread = new ExtendedThread(lock);
            extendedThread.setName("Thread"+i);
            extendedThread.start();
        }
    }

    private static class ExtendedThread extends Thread {

        private CustomReentrantLock lock;

        public ExtendedThread(CustomReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    this.lock.lock();
                    Thread.sleep(2000);
                    this.lock.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

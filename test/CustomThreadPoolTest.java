package test;

import threads.CustomThreadPool;

/**
 * @author Ramesh BG
 *
 */
public class CustomThreadPoolTest {

    /**
     * @author Ramesh BG
     *
     */
    private static final class ExtendedRunnable implements Runnable {
        /**
         * @param i
         */
        int i;
        
        public ExtendedRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {

            System.out.println("Value is " + i
                    + " Thread Name is "
                    + Thread.currentThread().getName());
        }
    }

    private CustomThreadPool threadPool;

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        new CustomThreadPoolTest().startAndSubmit();
    }

    private void startAndSubmit() throws InterruptedException {
        startThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new ExtendedRunnable(i));
        }
        threadPool.stopThreadPool();
    }
    private void startThreadPool() {
        threadPool = new CustomThreadPool();
    }
}

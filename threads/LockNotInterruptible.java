package threads;

/**
 * @author Ramesh BG
 *
 */
public class LockNotInterruptible {

    /**
     * @author Ramesh BG Test Case when thread is holding lock then intterupt is
     *         called on the thread but this doesn't affect thread.
     *
     */
    private static final class NewRunnable implements Runnable {

        Object obj;

        public NewRunnable(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (this.obj) {
                for (int i = 0;; i++) {
                    System.out.println("Thead Name "
                            + Thread.currentThread().getName() + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Object obj = new Object();
        Runnable runnable = new NewRunnable(obj);

        Thread thread = new Thread(runnable, "First ");
        thread.start();
        thread.interrupt();

        Thread secondThread = new Thread(new NewRunnable(obj), "Second ");
        secondThread.start();
    }
}

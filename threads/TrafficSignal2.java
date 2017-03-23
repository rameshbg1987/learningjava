/**
 * 
 */
package threads;

/**
 * @author Ramesh BG
 *
 */
public class TrafficSignal2 {

    /**
     * @author Ramesh BG
     *
     */
    private static final class RedRunnable implements Runnable {

        private LockCoordinator commonLock;

        /**
         * @param commonLock
         */
        public RedRunnable(LockCoordinator commonLock) {
            this.commonLock = commonLock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (commonLock) {
                    if (Thread.currentThread().getName()
                            .equals(this.commonLock.getNextThread())) {
                        System.out.println("RED");
                        this.commonLock.setNextThread("GREEN");
                        this.commonLock.notifyAll();
                    } else {
                        try {
                            this.commonLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * @author Ramesh BG
     *
     */
    private static final class GreenRunnable implements Runnable {
        /**
         * @param commonLock
         */
        private LockCoordinator commonLock;

        public GreenRunnable(LockCoordinator commonLock) {
            this.commonLock = commonLock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (commonLock) {
                    if (Thread.currentThread().getName()
                            .equals(this.commonLock.getNextThread())) {
                        System.out.println("GREEN");
                        this.commonLock.setNextThread("RED");
                        this.commonLock.notifyAll();
                    } else {
                        try {
                            this.commonLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LockCoordinator commonLock = new LockCoordinator();
        new Thread(new GreenRunnable(commonLock), "GREEN").start();
        new Thread(new RedRunnable(commonLock), "RED").start();
    }

    private static class LockCoordinator {
        String nextThread = "RED";

        public String getNextThread() {
            return this.nextThread;
        }

        public void setNextThread(String nextThread) {
            this.nextThread = nextThread;
        }
    }
}

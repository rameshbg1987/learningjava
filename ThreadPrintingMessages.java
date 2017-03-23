package threads;

/**
 * @author Ramesh BG 
 * There are THREE THREADS in program 
 * First thread prints "1 1 1...." 
 * Second thread prints "2 2 2..." 
 * Third thread prints "3 3 3..."
 * 
 * so aim of this program is to print "1 2 3 1 2 3 1 2 3...." in
 *         sequential manner.
 *
 */
public class ThreadPrintingMessages {

    /*
     * lock which is shared across all three threads.
     */
    private SharedLock sharedLock = new SharedLock();
    
    private volatile boolean shutdownFlag;

    private Thread firstThread;

    private Thread secondThread;

    private Thread thirdThread;

    private class SharedLock {

        String nextThread = NextThread.ONE.toString();

        public String getNextThread() {
            return this.nextThread;
        }

        public void setNextThread(String nextThread) {
            this.nextThread = nextThread;
        }

        public void performAction(String currentThread, String nextThread) {
            while (!shutdownFlag) {
                synchronized (ThreadPrintingMessages.this.sharedLock) {
                    if (getNextThread().equalsIgnoreCase(
                            Thread.currentThread().getName())) {
                        System.out.println(Thread.currentThread().getName());
                        ThreadPrintingMessages.this.sharedLock
                                .setNextThread(nextThread);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            shutdownFlag = true;
                        }
                        ThreadPrintingMessages.this.sharedLock.notifyAll();
                    } else {
                        try {
                            ThreadPrintingMessages.this.sharedLock.wait();
                        } catch (InterruptedException e) {
                            shutdownFlag = true;
                        }
                    }
                }
            }
        }
    }

    enum NextThread {
        ONE {
            @Override
            public String toString() {
                return "1";
            }
        },
        TWO {
            @Override
            public String toString() {
                return "2";
            }
        },
        THREE {
            @Override
            public String toString() {
                return "3";
            }
        };
    }

    private class FirstRunnable implements Runnable {

        @Override
        public void run() {
            ThreadPrintingMessages.this.sharedLock.performAction(
                    ThreadPrintingMessages.NextThread.ONE.toString(),
                    ThreadPrintingMessages.NextThread.TWO.toString());
        }
    }

    /**
     * @author Ramesh BG
     *
     */
    private class SecondRunnable implements Runnable {
        @Override
        public void run() {
            ThreadPrintingMessages.this.sharedLock.performAction(
                    ThreadPrintingMessages.NextThread.TWO.toString(),
                    ThreadPrintingMessages.NextThread.THREE.toString());
        }
    }

    /**
     * @author Ramesh BG
     *
     */
    private class ThirdRunnable implements Runnable {
        @Override
        public void run() {
            ThreadPrintingMessages.this.sharedLock.performAction(
                    ThreadPrintingMessages.NextThread.THREE.toString(),
                    ThreadPrintingMessages.NextThread.ONE.toString());
        }
    }
    
    public void stop() {
        firstThread.interrupt();
        secondThread.interrupt();
        thirdThread.interrupt();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new ThreadPrintingMessages().startThreads();
    }

    private void startThreads() {
        firstThread = new Thread(new FirstRunnable(),
                ThreadPrintingMessages.NextThread.ONE.toString());
        firstThread.start();
        secondThread = new Thread(new SecondRunnable(),
                ThreadPrintingMessages.NextThread.TWO.toString());
        secondThread.start();
        thirdThread = new Thread(new ThirdRunnable(),
                ThreadPrintingMessages.NextThread.THREE.toString());
        thirdThread.start();
    }
}

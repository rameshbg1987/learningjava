package threads;

import java.util.Random;

/**
 * @author Ramesh BG
 *
 */
public class EvenOddProblem {

    private enum NumberType {
        EVEN, ODD;
    }

    private SharedLock sharedLock = new SharedLock();

    private Thread evenThread = new Thread(new EvenRunnable(),
            NumberType.EVEN.name());

    private Thread oddThread = new Thread(new OddRunnable(),
            NumberType.ODD.name());

    private volatile boolean stopFlag;

    public void startPrintingNumbers() {
        evenThread.start();
        oddThread.start();
    }

    public void stopPrintingNumbers() {
        this.stopFlag = true;
        evenThread.interrupt();
        oddThread.interrupt();
    }

    private class EvenRunnable implements Runnable {

        @Override
        public void run() {
            EvenOddProblem.this.sharedLock.action(NumberType.ODD.name());
        }
    }

    private class OddRunnable implements Runnable {

        @Override
        public void run() {
            EvenOddProblem.this.sharedLock.action(NumberType.EVEN.name());
        }
    }

    private class SharedLock {

        private String nextThread = NumberType.EVEN.name();

        /*
         * guarded by "this:
         */
        private int i = 0;

        public String getNextThread() {
            return nextThread;
        }

        public void setNextThread(String nextThread) {
            this.nextThread = nextThread;
        }

        public void action(String nextSet) {
            while (!EvenOddProblem.this.stopFlag) {
                synchronized (EvenOddProblem.this.sharedLock) {
                    try {
                        if (Thread.currentThread().getName()
                                .equals(this.getNextThread())) {
                            System.out.println(
                                    "Thread " + Thread.currentThread().getName()
                                            + " " + i++);
                            this.setNextThread(nextSet);
                            this.notifyAll();
                            Thread.sleep(new Random().nextInt(300));
                        } else {
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        EvenOddProblem.this.stopFlag = true;
                    }
                }
            }
        }
    }
}

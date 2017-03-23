package threads;

/**
 * @author Ramesh BG
 *
 */
public class TrafficSignal {

    enum SignalColors {
        GREEN, RED;
    }

    private long delayBtwnThreads = 500;

    private SharedLock sharedLock = new SharedLock();

    private Thread greenThread = new Thread(new GreeRunnable(),
            SignalColors.GREEN.name());
    private Thread redThread = new Thread(new RedRunnable(),
            SignalColors.RED.name());

    private volatile boolean shutdownFlag;

    public TrafficSignal() {

    }

    public TrafficSignal(SignalColors colors) {
        this(colors, 1000);
    }

    public TrafficSignal(long delayBtwnThreads) {
        this(SignalColors.GREEN, delayBtwnThreads);
    }

    public TrafficSignal(SignalColors colors, long delayBtwnThreads) {
        this.delayBtwnThreads = delayBtwnThreads;
        this.sharedLock.setNextThread(colors.name());
    }

    public void start() {
        this.greenThread.start();
        this.redThread.start();
    }

    public void stop() {
        this.greenThread.interrupt();
        this.redThread.interrupt();
    }

    private class GreeRunnable implements Runnable {

        @Override
        public void run() {
            TrafficSignal.this.sharedLock.action(SignalColors.GREEN.name(),
                    SignalColors.RED.name());
        }
    }

    private class RedRunnable implements Runnable {

        @Override
        public void run() {
            TrafficSignal.this.sharedLock.action(SignalColors.RED.name(),
                    SignalColors.GREEN.name());
        }
    }

    private class SharedLock {

        private String nextThread = SignalColors.GREEN.name();

        public String getNextThread() {
            return nextThread;
        }

        public void setNextThread(String nextThread) {
            this.nextThread = nextThread;
        }

        public void action(String nextPrint, String nextSet) {
            while (!TrafficSignal.this.shutdownFlag) {
                synchronized (TrafficSignal.this.sharedLock) {
                    try {
                        if (Thread.currentThread().getName()
                                .equals(this.getNextThread())) {
                            System.out.println(nextPrint);
                            this.setNextThread(nextSet);
                            this.notifyAll();
                            Thread.sleep(TrafficSignal.this.delayBtwnThreads);
                        } else {
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        TrafficSignal.this.shutdownFlag = true;
                    }
                }
            }
        }
    }
}

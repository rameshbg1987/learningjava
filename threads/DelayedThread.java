package threads;

public class DelayedThread extends Thread {

    private DelayedQueue delayedQueue;

    private boolean isStopped;

    public DelayedThread(DelayedQueue delayedQueue, String string) {
        this.delayedQueue = delayedQueue;
        setName(string);
    }

    @Override
    public void run() {

        while (!isStopped)
            try {
                Runnable task = delayedQueue.getTask();
                if (task != null) {
                    task.run();
                }
            } catch (InterruptedException e) {
                this.isStopped = true;
                e.printStackTrace();
            }
    }

    public void shutdown() {
        this.interrupt();
        isStopped = true;
    }
}
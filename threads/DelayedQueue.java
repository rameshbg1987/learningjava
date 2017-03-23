package threads;

import java.util.concurrent.Delayed;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author r7b
 */
public class DelayedQueue {
    private PriorityBlockingQueue<DelayedTask<Delayed>> blockingQueue;

    public DelayedQueue() {
        this.blockingQueue = new PriorityBlockingQueue<DelayedTask<Delayed>>();
    }

    public void addTask(DelayedTask<Delayed> delayedTask) {
        this.blockingQueue.add(delayedTask);
    }

    public synchronized Runnable getTask() throws InterruptedException {
        /*
         * sort the task and take the first task in the queue.
         */
            return this.blockingQueue.take();
    }

    @Override
    public String toString() {
        return this.blockingQueue.toString();
    }
}
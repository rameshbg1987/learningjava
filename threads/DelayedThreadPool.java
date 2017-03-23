package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;

public class DelayedThreadPool {

    private List<DelayedThread> workers;

    private DelayedQueue delayedQueue;

    public DelayedThreadPool() {
        workers = new ArrayList<DelayedThread>();
        delayedQueue = new DelayedQueue();

        for (int i = 0; i < 10; i++) {
            DelayedThread newThread = new DelayedThread(delayedQueue,
                    String.valueOf(i));
            workers.add(newThread);
            newThread.start();
        }
    }

    public void addTask(DelayedTask<Delayed> taskToExecute) {
        this.delayedQueue.addTask(taskToExecute);
    }

    public void stop() {
        for (DelayedThread delayedThread : workers) {
            delayedThread.shutdown();
        }
    }
}
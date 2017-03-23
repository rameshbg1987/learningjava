package threads;

/**
 * @author Ramesh BG
 * implementation of ReentrantLock using wait and notify methods.
 */
public class CustomReentrantLock {

    private volatile Thread lockOwner;

    private volatile int count;

    public synchronized void lock() throws InterruptedException {
        if (lockOwner == null  || (lockOwner == Thread.currentThread())) {
            lockOwner = Thread.currentThread();
            count++;
        } else {
            this.wait();
        }
    }

    public synchronized void release() {
        if (lockOwner != null && this.lockOwner == Thread.currentThread()) {
            count--;
            if (count == 0) {
                lockOwner = null;
                this.notifyAll();
            }
        }
    }
}

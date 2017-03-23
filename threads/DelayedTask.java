package threads;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author r7b
 */
public abstract class DelayedTask<E> implements Delayed, Runnable {

    private long timeToExecute;

    public long getTimeToExecute() {
        return timeToExecute;
    }

    public DelayedTask(long timeToExecute) {
        this.timeToExecute = timeToExecute;
    }

    @Override
    public int compareTo(Delayed other) {
        if (this == other) {
            return 0;
        }
        if (getDelay(TimeUnit.MILLISECONDS) < other
                .getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        } else if (getDelay(TimeUnit.MILLISECONDS) > other
                .getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long currentTimeMillis = System.currentTimeMillis();
        long timeRemaining = currentTimeMillis - this.timeToExecute;
        return timeRemaining;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append("Time To Execute:")
                .append(this.timeToExecute).append("]");
        return stringBuilder.toString();
    }
}
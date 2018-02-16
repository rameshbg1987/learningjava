package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ramesh BG Program to test Statistics of ThreadPool Copied program
 *         from Java Concurrency In Practice
 */
public class ExtendedThreadPoolExecutor extends ThreadPoolExecutor {

    private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    private AtomicLong totalTime = new AtomicLong(0);

    private AtomicLong taskCount = new AtomicLong(0);

    private Logger LOG = Logger.getAnonymousLogger();

    /**
     * @param corePoolSize
     * @param maximumPoolSize
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     */
    public ExtendedThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        LOG.log(Level.INFO, "Thread Name is " + t + " Runnable is " + r);
        long currentTimeMillis = System.currentTimeMillis();
        startTime.set(currentTimeMillis);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long endTime = System.currentTimeMillis();
        long taskTime = endTime - startTime.get();
        totalTime.addAndGet(taskTime);
        taskCount.incrementAndGet();
        LOG.log(Level.INFO, "Thread Name is " + t + " Runnable is " + r
                + " \nTotal Task time is " + taskTime);
    }

    @Override
    protected void terminated() {
        LOG.log(Level.INFO, "Number of Tasks are " + taskCount);
        LOG.log(Level.INFO, "Average Time Each Task Takes "
                + totalTime.get() / taskCount.get());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExtendedThreadPoolExecutor extendedThreadPoolExecutor = new ExtendedThreadPoolExecutor(
                1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10; i++) {
            extendedThreadPoolExecutor.submit(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("this is runnable");
                    }
                }
            });

        }
        extendedThreadPoolExecutor.shutdown();
    }
}

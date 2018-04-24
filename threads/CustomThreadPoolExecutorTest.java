package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ramesh BG
 *
 */
class CustomThreadPoolExecutor extends ThreadPoolExecutor {

    private Logger logger = Logger.getLogger("CustomThreadPoolExecutor");

    private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    private static AtomicLong totalValue = new AtomicLong(0);

    private static AtomicLong numTasks = new AtomicLong(0);

    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(
                "ENTER:Current Thread is " + Thread.currentThread().getName()
                        + " Time is " + currentTimeMillis);
        threadLocal.set(currentTimeMillis);
        logger.log(Level.INFO, "Entered beforeExecute Thread Name is "
                + Thread.currentThread().getName());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            super.afterExecute(r, t);
            logger.log(Level.INFO, "Exited afterExecute Thread Name is "
                    + Thread.currentThread().getName());
            System.out.println(
                    "EXIT:Current Thread is " + Thread.currentThread().getName()
                            + " Time is " + System.currentTimeMillis());
        } finally {
            System.out.println(
                    "Initial Value for " + Thread.currentThread().getName()
                            + " is " + threadLocal.get());
            totalValue
                    .getAndAdd(System.currentTimeMillis() - threadLocal.get());
            numTasks.getAndIncrement();
            logger.log(Level.INFO, Thread.currentThread().getName()
                    + " runtime value is " + totalValue.get());
        }
    }

    @Override
    protected void terminated() {
        super.terminated();
        logger.log(Level.INFO, "Total time taken is " + totalValue.get());
        logger.log(Level.INFO, "Average time for all tasks is "
                + totalValue.get() / numTasks.get());
    }

}

public class CustomThreadPoolExecutorTest {
    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(
                4, 10, 1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 4; i++) {
            customThreadPoolExecutor.submit(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        for (int k = 0; k < 100; k++) {
                            System.out.print("hello");
                        }
                    }
                }
            });
        }
        customThreadPoolExecutor.shutdown();
    }
}

package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Ramesh BG
 *
 */
public class FixedPoolExample {

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors
                .newFixedThreadPool(1);
        executorService.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy());
        Future<String> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "this is return value";
            }
        });

        try {
            future.get(100, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
            future.cancel(true);
        }

        executorService.submit(new Runnable() {
            public void run() {
                System.out.println(
                        "Thread Name is " + Thread.currentThread().getName());
                System.out.println("this is new runnable ");
            }
        });
        executorService.shutdown();

        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(
                Executors.newSingleThreadExecutor());
    }
}

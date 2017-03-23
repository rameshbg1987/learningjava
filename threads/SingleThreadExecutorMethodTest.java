package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Ramesh BG
 *
 */
public class SingleThreadExecutorMethodTest {

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        singleThreadExecution();
    }

    private static void singleThreadExecution()
            throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("this is ramesh");
                return "hello";
            }
        });
        System.out.println(future.get());
        executorService.shutdown();
    }
}

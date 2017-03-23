package threads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Ramesh BG
 *
 */
public class ExecutorTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ExecutorTest executorTest = null;
        try {
            executorTest = new ExecutorTest();
            executorTest.returnValue();
            executorTest.returnException();
            executorTest.shutdown();
        } finally {
            Objects.requireNonNull(executorTest).shutdown();
        }
        
    }

    private void shutdown() {
        Objects.requireNonNull(this.executorService).shutdown();
    }

    private void returnValue() throws InterruptedException, ExecutionException {

        Future<String> submit = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        String string = submit.get();
        System.out.println(string);
    }

    private void returnException()
            throws InterruptedException, ExecutionException {
        Future<String> submit = executorService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                throw new RuntimeException();
            }
        });
        String string = submit.get();
        System.out.println(string);
    }
}

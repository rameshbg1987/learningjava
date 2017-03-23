package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Ramesh BG
 *
 */
public class DeadLockExampleTest {

    /**
     * FirstTask submitting secondtask to executorservice results in
     * deadlock.
     * 
     * Main Thread waits for First Task
     * First Task initiates and waits for Second Task
     * Second Task is never executed since first task is not completed and there is only one thread in Pool.
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> firstFuture = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("This is first task");
                Future<Integer> secondFuture = executorService.submit(new Callable<Integer>() {

                    @Override
                    public Integer call() throws Exception {
                        return 10;
                    }
                });
                Integer secondInteger = secondFuture.get();
                System.out.println("Second Task result "+secondInteger);
                return 5;
            }
        });
        Integer firstInteger = firstFuture.get();
        System.out.println("First Task result "+firstInteger);
        executorService.shutdown();
    }
}

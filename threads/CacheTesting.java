package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Ramesh BG
 *
 */
public class CacheTesting {

    /**
     * @param args
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
         newMethod();
    }

    private static String newMethod()
            throws InterruptedException, ExecutionException {
        ConcurrentHashMap<String, Future<String>> concurrentHashMap = new ConcurrentHashMap<>();
        String key = null;

        FutureTask<String> futureTask = new FutureTask<String>(
                new Callable<String>() {

                    @Override
                    public String call() throws Exception {
                        return "hello";
                    }

                });

        Future<String> future = concurrentHashMap.get(key);
        if (future == null) {
            concurrentHashMap.putIfAbsent(key, futureTask);
            futureTask.run();
        } else {
            return future.get();
        }
        return futureTask.get();
    }
}

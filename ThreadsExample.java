package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ramesh BG
 *
 */
public class ThreadsExample {

    private static int i;

    /**
     * @author Ramesh BG
     */
    private static final class ExtendedCallable implements Callable<Void> {

        int value;

        public ExtendedCallable(int value) {
            this.value = value;
        }

        @Override
        public Void call() throws Exception {
            System.out.println("this is " + this.value);
            return null;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Void>> list = new ArrayList<>();

        for (i = 1; i <= 10; i++) {
            Callable<Void> callable = new ExtendedCallable(i);
            list.add(callable);
        }
        try {
            executorService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

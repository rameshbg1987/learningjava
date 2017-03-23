package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javafx.util.Pair;

/**
 * I have to create 5 threads where each thread has to perform the addition operation. 
 * Thread1 - Add 1 to 10 
 * Thread2 - Add 1 to 50 
 * Thread3 - Add 5 to 15 
 * Thread4 - Add 10 to 20
 * Thread5 - Add 15 to 20 
 * What is the best way to accomplish this?  Also, I need 1 sec time delay between each addition operation.
 * Answer: Caching addition operation results in ConcurrentHashMap so that addition of same numbers is not performed again.
 * @author Ramesh BG
 *
 */
public class MultiThreadAddition {

    /*
     * sharedConcurrentHashMap is shared across all threads to cache the results
     * of addition operation.
     */
    private ConcurrentHashMap<Pair<Integer, Integer>, Future<Integer>> sharedConcurrentHashMap = new ConcurrentHashMap<>();

    private Thread firstThread;
    private Thread secondThread;
    private Thread thirdThread;
    private Thread fourthThread;
    private Thread fifthThread;

    private Object sharedLock = new Object();

    /**
     * @author Ramesh BG
     *
     */
    private final class ExtendedCallable implements Callable<Integer> {
        /**
         * @param pair
         */
        Pair<Integer, Integer> pair;

        public ExtendedCallable(Pair<Integer, Integer> pair) {
            this.pair = pair;
        }

        @Override
        public Integer call() throws Exception {
            int result = 0;
            synchronized (sharedLock) {
                Thread.sleep(1000);
            }
            result = pair.getKey() + pair.getValue();
            System.out.println("Thread: " + Thread.currentThread().getName()
                    + " sum of pair " + pair + " is " + result);
            return result;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new MultiThreadAddition().createThreads();
    }

    public void createThreads() {
        firstThread = new Thread(new Runnable() {

            @Override
            public void run() {
                new Addition(1, 10).add();
            }
        });
        firstThread.start();

        secondThread = new Thread(new Runnable() {

            @Override
            public void run() {
                new Addition(1, 50).add();
            }
        });
        secondThread.start();

        thirdThread = new Thread(new Runnable() {

            @Override
            public void run() {
                new Addition(5, 15).add();
            }
        });
        thirdThread.start();

        fourthThread = new Thread(new Runnable() {

            @Override
            public void run() {
                new Addition(10, 20).add();
            }
        });
        fourthThread.start();

        fifthThread = new Thread(new Runnable() {

            @Override
            public void run() {
                new Addition(15, 20).add();
            }
        });
        fifthThread.start();
    }

    private class Addition {

        private int lowerRange;

        private int upperRange;

        public Addition(int lowerRange, int upperRange) {
            this.lowerRange = lowerRange;
            this.upperRange = upperRange;
        }

        public int add() {
            int result = 0;
            int firstNumber = 0;
            int secondNumber = 0;
            for (int i = this.lowerRange; i <= this.upperRange; i = i + 2) {

                if ((i & 1) == 1) {
                    firstNumber = i;
                    /*
                     * if upperRange is oddNumber
                     */
                    if (i + 1 <= this.upperRange) {
                        secondNumber = i + 1;
                    }
                } else {
                    result = result + i;
                    firstNumber = i + 1;
                    secondNumber = i + 2;
                    i = i + 1;
                }

                Pair<Integer, Integer> pair = new Pair<>(firstNumber,
                        secondNumber);
                Future<Integer> future = sharedConcurrentHashMap.get(pair);

                if (future == null) {
                    FutureTask<Integer> futureTask = new FutureTask<Integer>(
                            new ExtendedCallable(pair));
                    future = futureTask;
                    sharedConcurrentHashMap.putIfAbsent(pair, futureTask);
                    futureTask.run();
                } else {
                    try {
                        System.out.println(
                                "Thread: " + Thread.currentThread().getName()
                                        + " uses CACHED VALUE for pair " + pair
                                        + " result is " + future.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Integer integer = future.get();
                    result = result + integer;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /*
                 * reset number, do not want to use same numbers in next
                 * iteration.
                 */
                firstNumber = 0;
                secondNumber = 0;
            } // end of for loop

            System.out.println("THREAD: " + Thread.currentThread().getName()
                    + " SUM FROM " + this.lowerRange + " TO " + this.upperRange
                    + " IS " + result);
            return result;
        }
    }
}

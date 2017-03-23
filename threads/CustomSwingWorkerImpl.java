package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Ramesh BG
 * @param <V>
 *
 */
public class CustomSwingWorkerImpl<V> implements Future<V>, Runnable {

    FutureTask<V> futureTask = null;
    
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    
    public CustomSwingWorkerImpl() {
        Callable<V> callable = new Callable<V>() {

            @Override
            public V call() throws Exception {
                return computeInBackground();
            }
        };
        
        this.futureTask = new FutureTask<V>(callable);
        
        class ExtendedFutureTask extends FutureTask<V> {

            /**
             * @param callable
             */
            public ExtendedFutureTask(Callable<V> callable) {
                super(callable);
            }
            
            @Override
            protected void done() {
                executorService.shutdown();
                updateGUI();
            }
        }
    }
    
    /**
     * invoked in background thread
     */
    protected V computeInBackground() {
        
        /*
         * do the lenghty operations here.
         */
        return null;
        
    }

    @Override
    public void run() {
        futureTask.run();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return futureTask.cancel(mayInterruptIfRunning);
    }

    @Override
    public boolean isCancelled() {
        return futureTask.isCancelled();
    }

    @Override
    public boolean isDone() {
        return futureTask.isDone();
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return futureTask.get();
    }

    @Override
    public V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        return futureTask.get(timeout, unit);
    }
    
    public void updateGUI() {
        /*
         * GUI updation should be done here.
         */
    }

}

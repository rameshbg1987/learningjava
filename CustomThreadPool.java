package threads;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Ramesh BG
 *
 */
public class CustomThreadPool {

    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    private List<Thread> threads = new ArrayList<Thread>();
    
    private int maxNoOfThreads = 10;
    
    private AtomicBoolean shutDownFlag = new AtomicBoolean(false);

    public CustomThreadPool() {
        startThreadPool();
    }
    
    public CustomThreadPool(int maxNoOfThreads) {
        this.maxNoOfThreads = maxNoOfThreads;
        startThreadPool();
    }

    private void startThreadPool() {
        for (int i = 1; i <= this.maxNoOfThreads; i++) {
            CustomThread thread = new CustomThread(queue);
            threads.add(thread);
            thread.start();
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        if(this.shutDownFlag.get()) {
           throw new RuntimeException("ThreadPool has been already shut down"); 
        }
        this.queue.put(runnable);
    }
    
    public void stopThreadPool() {
        if(!this.shutDownFlag.get()) {
            this.shutDownFlag.set(true);
            for (Thread thread : threads) {
                thread.interrupt();
            }
        } else {
            throw new RuntimeException("ThreadPool has been shutdown already");
        }
    }
    
    /**
     * @author Ramesh BG
     *
     */
    public static final class RunnableInstance implements Runnable {
        
        int i;
        public RunnableInstance(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Thread name is "+name+" value is "+i);
        }
    }

    private class CustomThread extends Thread {
        
        private BlockingQueue<Runnable> queue;
        
        public CustomThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }
        
        @Override
        public void run() {
            while(!shutDownFlag.get()) {
                try {
                    Runnable runnable = this.queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    shutDownFlag.set(true);
                }
            }
            System.out.println("Exited thread name is "+Thread.currentThread().getName());
        }
    }
}
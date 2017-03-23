package threads;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author Ramesh BG
 *
 */
public class CatchUnCaughtException {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                System.out.println("this is runnable");
                throw new RuntimeException();
            }
        };
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("this is uncaughtException method");
            }
        });
        thread.start();
    }
}

package threads;

/**
 * This Program shows difference between running thread by calling start() and
 * run() in two seperate methods
 * 
 * @author Ramesh BG
 *
 */
public class DiffBetweenCallingRunAndStartMethodsDirectly {

    /**
     * @param args
     */
    public static void main(String[] args) {
        callingRunMethodDirectly();
        callingThreadStart();
    }

    private static void callingRunMethodDirectly() {
        Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                System.out.println("Thread Name is "+Thread.currentThread().getName());
            }
        };
        Thread thread = new Thread(runnable);
        thread.run();
    }
    
    private static void callingThreadStart() {
        Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                System.out.println("Thread Name is "+Thread.currentThread().getName());
            }
        };
        Thread thread = new Thread(runnable,"NEW_THREAD");
        thread.start();
    }
}

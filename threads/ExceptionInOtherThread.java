package threads;

/**
 * @author Ramesh BG
 *
 */
public class ExceptionInOtherThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("this is " + Thread.currentThread().getName());
        
        try {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out
                            .println("this is " + Thread.currentThread().getName());
                    throw new RuntimeException();
                }
            }, "ANOTHER_THREAD");
            thread.start();
        } catch(Exception e) {
            System.out.println("Exception not caught here");
        }
    }
}

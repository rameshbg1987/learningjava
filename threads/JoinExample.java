package threads;

/**
 * @author Ramesh BG
 *
 */
public class JoinExample {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("this is inner thread " + i);
                }
            }
        });
        newThread.start();
        newThread.join();
        for (int i = 0; i < 10; i++) {
            System.out.println("this is main thread " +i);
        }
    }
}

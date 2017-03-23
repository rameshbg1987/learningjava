package threads;

/**
 * @author Ramesh BG
 *
 */
public class InterruptStatus {

    /**
     * @param args
     */
    public static void main(String[] args) {
        example_one_with_sleep();
        example_two_without_sleep();
    }

    private static void example_two_without_sleep() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(i);
                    }
                } finally {
                    System.out.println("Is interrupted "
                            + Thread.currentThread().isInterrupted());
                    System.out.println(Thread.interrupted());
                }
            }
        });
        thread.start();
        thread.interrupt();
    }

    private static void example_one_with_sleep() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(1000);
                        System.out.println(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Is interrupted "
                            + Thread.currentThread().isInterrupted());
                    System.out.println(Thread.interrupted());
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
}

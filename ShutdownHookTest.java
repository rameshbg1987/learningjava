package threads;

/**
 * @author Ramesh BG
 *
 */
public class ShutdownHookTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("shutdown hook");
            }
        }));
    }
}

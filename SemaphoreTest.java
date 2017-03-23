package threads;
import java.util.concurrent.Semaphore;

/**
 * @author Ramesh BG
 *
 */
public class SemaphoreTest {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        semaphore.release();
    }
}

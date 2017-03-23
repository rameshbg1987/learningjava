package threads;

/**
 * @author Ramesh BG
 *
 */
public class CallingStartMethodMultiple {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}

package threads;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Ramesh BG
 *
 */
public class TimerUsage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                System.out.println("this is first task");
            }
        }, 0);
        
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                System.out.println("this is second task");
                timer.cancel();
            }
        }, 0);
    }
}

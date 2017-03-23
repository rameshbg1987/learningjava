package threads;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Ramesh BG
 *
 */
public class TimerVsScheduledThreadPool {

    /**
     * @param args
     */
    public static void main(String[] args) {
        timerExecution();
        scheduledthreadpoolexecution();
    }

    private static void timerExecution() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                throw new RuntimeException();
            }
        }, 0);

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("this is second task");
            }
        }, 10);

        System.out.println(
                "observe second task is not executed bcoz thread is dead");
        System.out.println("this is end of main method");
    }

    private static void scheduledthreadpoolexecution() {
        ScheduledExecutorService executors = Executors
                .newScheduledThreadPool(1);
        executors.submit(new Runnable() {

            @Override
            public void run() {
                throw new RuntimeException();
            }
        });

        executors.submit(new Runnable() {

            @Override
            public void run() {
                System.out.println("this is second task from scheduled thread pool executor");
            }
        });
        executors.shutdown();
        System.out.println(
                "observe second task is executed successfully when executed via scheduledexecutorservice");
    }
}

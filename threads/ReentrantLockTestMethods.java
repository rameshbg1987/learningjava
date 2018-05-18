package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ramesh BG
 *
 */
public class ReentrantLockTestMethods {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            try {
                boolean tryLock = reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS);
                System.out.println(tryLock);
                System.out.println("hello world");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            reentrantLock.unlock();
            System.out.println("Lock released");
        }
    }
    
    public void lockInterruptibleTest() {
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            try {
                reentrantLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

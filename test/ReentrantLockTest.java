package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ramesh BG
 *
 */
public class ReentrantLockTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
    }

}

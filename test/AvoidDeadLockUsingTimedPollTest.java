package test;

import java.util.concurrent.TimeUnit;

import threads.AccountWithReentrantLock;
import threads.AvoidDeadLockUsingTimedPoll;

/**
 * @author Ramesh BG
 *
 */
public class AvoidDeadLockUsingTimedPollTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AvoidDeadLockUsingTimedPoll avoidDeadLockUsingTimedPoll = new AvoidDeadLockUsingTimedPoll();
        AccountWithReentrantLock fromAccount = new AccountWithReentrantLock(
                "abc", 1234, 10000);
        AccountWithReentrantLock toAccount = new AccountWithReentrantLock("pqr",
                5678, 10000);

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    avoidDeadLockUsingTimedPoll.transferMoney(2000, fromAccount,
                            toAccount, 100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    avoidDeadLockUsingTimedPoll.transferMoney(2000, toAccount,
                            fromAccount, 100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread2.start();

        System.out.println("AFTER TRANSACTION");
        System.out.println("Balance of " + fromAccount.getName() + " "
                + fromAccount.getAmount());
        System.out.println("Balance of " + toAccount.getName() + " "
                + toAccount.getAmount());
    }

}

package threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Ramesh BG
 *
 */
public class AvoidDeadLockUsingTimedPoll {

    public boolean transferMoney(int amount,
            AccountWithReentrantLock fromAccount,
            AccountWithReentrantLock toAccount, long timeout, TimeUnit timeUnit)
            throws InterruptedException {

        long startTime = System.nanoTime();

        while (true) {

            try {
                if (fromAccount.getLock().tryLock()) {
                    try {
                        if (toAccount.getLock().tryLock()) {
                            deductMoney(amount, fromAccount, toAccount);
                            return true;
                        }
                    } finally {
                        toAccount.getLock().unlock();
                    }
                }
            } finally {
                fromAccount.getLock().unlock();
            }

            long endTime = System.nanoTime() - startTime;

            if (endTime < timeout) {
                //retry the operation after random sleep
                Random random = new Random();
                Thread.sleep(1000 + random.nextInt(1000));
            } else {
                //if timed out, return false saying operation failed.
                return false;
            }

        }

    }

    private void deductMoney(int amount, AccountWithReentrantLock fromAccount,
            AccountWithReentrantLock toAccount) {
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + amount);
    }
}

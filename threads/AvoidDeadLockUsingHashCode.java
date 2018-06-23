package threads;

/**
 * @author Ramesh BG This is the example provided in java concurrency in
 *         practice book, used here for practice
 *         //There is no deadlock after using this code.
 *
 */
public class AvoidDeadLockUsingHashCode {

    private Object dummyLock = new Object();

    public boolean transferMoney(int amount, Account fromAccount,
            Account toAccount) {
        
        
        if(fromAccount.getAmount() < amount) {
            throw new RuntimeException("BALANCE IS NOT SUFFICIENT FOR TRANSFER");
        }

        int fromAccountHashCode = System.identityHashCode(fromAccount);
        int toAccountHashCode = System
                .identityHashCode(toAccount);
        System.out.println("fromAccount HashCode "+fromAccountHashCode);
        System.out.println("toAccount HashCode "+toAccountHashCode);
        
        if (fromAccountHashCode < toAccountHashCode) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    System.out.println("Acquired fromAccount and toAccount Locks in order");
                    System.out.println("Deducting Money from fromAccount and credited to toAccount");
                    deductMoney(amount, fromAccount, toAccount);
                    return true;
                }
            }
        } else if (fromAccountHashCode > toAccountHashCode) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    System.out.println("Acquired toAccount and fromAccount Locks in order");
                    System.out.println("Deducting Money from fromAccount and credited to toAccount");
                    deductMoney(amount, fromAccount, toAccount);
                    return true;
                }
            }
        } else {
            synchronized (dummyLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        System.out.println("HASH CODE ARE EQUAL");
                        System.out.println("Acquired fromAccount and toAccount Locks in order");
                        System.out.println("Deducting Money from fromAccount and credited to toAccount");
                        deductMoney(amount, fromAccount, toAccount);
                        return true;
                    }
                }
            }
        }
    }

    private void deductMoney(int amount, Account fromAccount,
            Account toAccount) {
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + amount);
    }
}

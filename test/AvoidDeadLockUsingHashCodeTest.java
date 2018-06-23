package test;

import threads.Account;
import threads.AvoidDeadLockUsingHashCode;

/**
 * @author Ramesh BG
 *
 */
public class AvoidDeadLockUsingHashCodeTest {
    
    public static void main(String[] args) {
        AvoidDeadLockUsingHashCode avoidDeadLockUsingHashCode = new AvoidDeadLockUsingHashCode();
        Account fromAccount = new Account("abc",1234,10000);
        Account toAccount = new Account("pqr", 5678, 10000);
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                avoidDeadLockUsingHashCode.transferMoney(2000, fromAccount, toAccount);
            }
        }).start();
        
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                avoidDeadLockUsingHashCode.transferMoney(2000, toAccount, fromAccount);
            }
        }).start();
        
        
        System.out.println("AFTER TRANSACTION");
        System.out.println("Balance of "+fromAccount.getName()+" "+fromAccount.getAmount());
        System.out.println("Balance of "+toAccount.getName()+" "+toAccount.getAmount());
    }
}

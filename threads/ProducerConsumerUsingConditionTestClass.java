package threads;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ramesh BG Not Correct Program
 */
public class ProducerConsumerUsingConditionTestClass {

    public static void main(String[] args) {
        ProducerConsumerUsingCondition producerConsumerUsingCondition = new ProducerConsumerUsingCondition();

        Thread putThread = new Thread(new Runnable() {

            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    try {
                        int nextInt = random.nextInt(1000);
                        producerConsumerUsingCondition.putElement(nextInt);
                        System.out.println("INSERTED ELEMENT IS " + nextInt);
                        System.out.println("Queue Contents After Insertion is "
                                + producerConsumerUsingCondition
                                        .bufferContents());
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } 
                }
            }
        },"ADD_THREAD");
        putThread.start();
        Thread removeThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        int removeElement = producerConsumerUsingCondition
                                .removeElement();
                        System.out
                                .println("REMOVED ELEMENT IS " + removeElement);
                        System.out.println("Queue Contents After Deletion is "
                                + producerConsumerUsingCondition
                                        .bufferContents());
                        Thread.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } 
                }
            }
        },"REMOVE_THREAD");
        removeThread.start();
    }
}

class ProducerConsumerUsingCondition {

    private int head = -1;

    private int rear = -1;

    private int MAX_SIZE = 10;

    private int[] buffer = new int[MAX_SIZE];

    private ReentrantLock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    public void putElement(int element) throws InterruptedException {
        try {
            lock.lock();
            if (++rear == MAX_SIZE) {
                System.out.println("Queue full waiting for removal");
                rear = -1;
                notFull.await();
            }
            if (head == -1) {
                ++head;
            }
            if(rear == -1) {
                ++rear;
            }
            buffer[rear] = element;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int removeElement() throws InterruptedException {
        try {
            lock.lock();
            if (head == -1) {
                System.out.println("empty waiting");
                notEmpty.await();
            }
            int elementToRemove = buffer[head];
            buffer[head] = 0;
            head++;
            if (head > rear) {
                head = -1;
                rear = -1;
            }
            if(head== MAX_SIZE) {
                head = -1;
            }
            notFull.signal();
            return elementToRemove;
        } finally {
            lock.unlock();
        }
    }

    public String bufferContents() {
        return Arrays.toString(buffer);
    }

    public ReentrantLock getLock() {
        return this.lock;
    }
}
package test;

import java.util.Random;

import threads.CustomBlockingQueueImpl;

/**
 * @author Ramesh BG
 *
 */
public class CustomBlockingQueueImplTest {

    private CustomBlockingQueueImpl<Integer> blockingQueue = new CustomBlockingQueueImpl<>();

    private Thread addThread = null;

    private Thread removeThread = null;

    public void testAll() {
        addElement();
        removeElement();
    }

    public void addElement() {
        addThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        blockingQueue.add(new Random().nextInt());
                        int nextInt = new Random().nextInt(500);
                        System.out.println("sleep value in addElement is "+nextInt);
                        Thread.sleep(nextInt);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"ADD_THREAD");
        addThread.start();
    }

    public void removeElement() {

        removeThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Integer removedElement = blockingQueue.remove();
                        System.out.println(
                                "removed element is " + removedElement);
                        int nextInt = new Random().nextInt(500);
                        System.out.println("sleep value in removeElement is "+nextInt);
                        Thread.sleep(nextInt);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"REMOVE_THREAD");
        removeThread.start();
    }
    
    public static void main(String[] args) {
        CustomBlockingQueueImplTest blockingQueueImplTest = new CustomBlockingQueueImplTest();
        blockingQueueImplTest.addElement();
        blockingQueueImplTest.removeElement();
    }
}

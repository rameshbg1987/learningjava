package threads;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

class BlockingQueueImpl {
    
    private LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();

    private int MAX_SIZE = 10;

    public void put(String str) throws InterruptedException {
        synchronized (this) {
            if (linkedBlockingQueue.size() == MAX_SIZE) {
                System.out.println("ADDITION OPERATION IS WAITING FOR NOTIFICATION");
                this.wait();
            }
            this.linkedBlockingQueue.put(str);
            System.out.println();
            System.out.println("Element " + str + " added successfully");
            System.out.println("QUEUE CONTENTS AFTER ADDITION ARE "+linkedBlockingQueue.toString());
            System.out.println();
            this.notifyAll();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            if (linkedBlockingQueue.size() == 0) {
                System.out.println("REMOVAL OPERATION IS WAITING FOR NOTIFICATION");
                this.wait();
            }
            String returnedElement = this.linkedBlockingQueue.poll();
            System.out.println();
            System.out.println("Removed Element is "+returnedElement);
            System.out.println("QUEUE CONTENTS AFTER REMOVE ARE "+linkedBlockingQueue.toString());
            System.out.println();
            this.notifyAll();
            return returnedElement;
        }
    }
  
    @Override
    public String toString() {
        return linkedBlockingQueue.toString();
    }
}

public class BlockingQueueImplTest {
    
    private volatile boolean stop;
    
    public static void main(String[] args) {
        BlockingQueueImplTest blockingQueueImplTest = new BlockingQueueImplTest();
        blockingQueueImplTest.createGUI(blockingQueueImplTest);
    }

    private void startAction() {
        BlockingQueueImpl blockingQueueImpl = new BlockingQueueImpl();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(!isStop()) {
                    try {
                        Random random = new Random();
                        int randomValue = random.nextInt(2000);
                        Thread.sleep(randomValue);
                        blockingQueueImpl
                                .put(String.valueOf(random.nextInt(1000)));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } 
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while(!isStop()) {
                    try {
                        Random random = new Random();
                        int randomVal = random.nextInt(2000);
                        Thread.sleep(randomVal);
                        blockingQueueImpl.take();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } 
                }
            }
        }).start();
    }
    
    public void stop() {
        this.setStop(true);
    }

    /**
     * @param blockingQueueImplTest 
     * 
     */
    private void createGUI(BlockingQueueImplTest blockingQueueImplTest) {
        JFrame jFrame = new JFrame("BLOCKING QUEUE TEST");
        jFrame.setSize(300, 300);
        jFrame.setLayout(new FlowLayout());
        JButton startButton = new JButton("START");
        jFrame.add(startButton);
        startButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                blockingQueueImplTest.startAction();
            }
        });
        JButton closeButton = new JButton("STOP");
        jFrame.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                blockingQueueImplTest.stop();
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public boolean isStop() {
        return this.stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
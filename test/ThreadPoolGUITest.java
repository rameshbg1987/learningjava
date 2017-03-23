package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import threads.CustomThreadPool;

/**
 * @author Ramesh BG
 *
 */
public class ThreadPoolGUITest {

    /**
     * @author Ramesh BG
     *
     */
    private static final class ExtendedRunnable implements Runnable {
        /**
         * @param i
         */
        int i;
        
        public ExtendedRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {

            System.out.println("Value is " + i
                    + " Thread Name is "
                    + Thread.currentThread().getName());
        }
    }

    private CustomThreadPool threadPool;

    /**
     * @param args
     */
    public static void main(String[] args) {
        new ThreadPoolGUITest().startGUI();
    }

    private void startGUI() {
        JFrame jFrame = new JFrame("TEST THREAD POOL");
        jFrame.setSize(400, 400);
        jFrame.setLayout(new FlowLayout());
        JButton startButton = new JButton("START");
        jFrame.add(startButton);
        startThreadPool();
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 10; i++) {
                        threadPool.submit(new ExtendedRunnable(i));
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton stopButton = new JButton("STOP");
        jFrame.add(stopButton);
        stopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                threadPool.stopThreadPool();
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private void startThreadPool() {
        threadPool = new CustomThreadPool();
    }
}

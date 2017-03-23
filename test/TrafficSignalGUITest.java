package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import threads.TrafficSignal;


/**
 * @author Ramesh BG
 *
 */
public class TrafficSignalGUITest {

    private TrafficSignal trafficSignalNewVersion = new TrafficSignal();

    /**
     * @param args
     */
    public static void main(String[] args) {
        new TrafficSignalGUITest().startGUI();
    }

    private void startGUI() {
        JFrame jFrame = new JFrame("TEST TRAFFIC SIGNAL PROBLEM");
        jFrame.setSize(300, 100);
        jFrame.setLayout(new FlowLayout());
        JButton startButton = new JButton("START");
        jFrame.add(startButton);
        jFrame.setResizable(false);
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                trafficSignalNewVersion.start();  
            }
        });
        JButton stopButton = new JButton("STOP");
        jFrame.add(stopButton);
        stopButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                trafficSignalNewVersion.stop();
                jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

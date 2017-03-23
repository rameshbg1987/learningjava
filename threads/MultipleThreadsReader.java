package threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ramesh BG
 */
public class MultipleThreadsReader {

    private ReentrantLock reentrantLock = new ReentrantLock();

    private String nextThread = "0";

    private Thread[] threads;

    private BufferedReader bufferedReader;

    private String readLine;

    private int nextLocationInArray = 0;

    private String[] stringArray;

    private Condition condition = reentrantLock.newCondition();
    
    private volatile boolean shutdownFlag;

    public MultipleThreadsReader() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(
                new File("C:\\Users\\rbgangad.ORADEV\\Desktop\\threads.txt")));
    }

    public MultipleThreadsReader(String filePath) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new MultipleThreadsReader().createThreads(5);
    }

    private void printNextWord() throws FileNotFoundException, IOException {
        if (readLine == null || (nextLocationInArray == stringArray.length)) {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                stop();
                return;
            } else {
                stringArray = readLine.split(" ");
                nextLocationInArray = 0;
            }
        }
        System.out.println("Thread Name is " + Thread.currentThread().getName()
                + " read value by thread is "
                + stringArray[nextLocationInArray++]);

    }

    private void createThreads(int noOfThreads) {

        threads = new Thread[noOfThreads];

        for (int i = 0; i < noOfThreads; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (!shutdownFlag) {
                        try {
                            MultipleThreadsReader.this.reentrantLock.lockInterruptibly();
                            if (Thread.currentThread().getName()
                                    .equalsIgnoreCase(nextThread)) {
                                try {
                                    MultipleThreadsReader.this.printNextWord();
                                    int threadNameInInt = (Integer.valueOf(
                                            Thread.currentThread().getName())
                                            + 1) % noOfThreads;
                                    MultipleThreadsReader.this.nextThread = String
                                            .valueOf(threadNameInInt);
                                    condition.signalAll();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    condition.await();
                                } catch (InterruptedException e) {
                                    System.out.println(
                                            "Interrupted thread name is "
                                                    + Thread.currentThread()
                                                            .getName());
                                    shutdownFlag = true;
                                }
                            }
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        } finally {
                            MultipleThreadsReader.this.reentrantLock.unlock();
                        }
                    }
                }

            }, String.valueOf(i));
            threads[i] = thread;
            thread.start();
        }
    }
    
    public void stop() {
        this.shutdownFlag = true;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}

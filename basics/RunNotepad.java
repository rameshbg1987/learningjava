package basics;

import java.io.IOException;

/**
 * @author Ramesh BG
 *
 */
public class RunNotepad {

    /**
     * Program to launch notepad.exe from java.
     */
    public static void main(String[] args)
            throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("notepad.exe");
        int waitFor = process.waitFor();
        System.out.println(waitFor);
    }
}

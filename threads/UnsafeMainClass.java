package threads;

import java.util.Arrays;

class UnsafeStates {
    private String[] states = new String[] { "AK", "AL" };

    public String[] getStates() {
        return states;
    }
}

public class UnsafeMainClass {
    public static void main(String[] args) {
        UnsafeStates unsafeStates = new UnsafeStates();
        String[] states = unsafeStates.getStates();
        states = new String[] { "hello" };
        System.out.println(Arrays.toString(states));
        System.out.println(Arrays.toString(unsafeStates.getStates()));
    }
}
package basics;

/**
 * @author Ramesh BG
 *
 */
public class ShorthandOperators {

    public static void main(String[] args) {
        /**
         * Advantages of Shorthand notations
         * 
         * 1. less typing for users. 
         * 2. implicit casting provided by the compiler
         */

        int a = 5;
        a += 90; // similar to a=a+90
        System.out.println(a);

        // implicit casting provided by the compiler.
        byte c = 5;
        c += 90; // similar to c=(byte)(c+90)
        /*
         * we haven't provided (byte) casting in the expression but the compiler
         * itself will be provided.
         */
        System.out.println(c);
    }
}

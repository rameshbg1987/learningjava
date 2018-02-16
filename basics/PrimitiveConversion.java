package basics;

/**
 * @author Ramesh BG
 *
 */
public class PrimitiveConversion {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // integers are implicit casted by the compiler
        char a = 45;
        System.out.println(a);
        
        
        //No error because it is in range.
        byte b = 127;
        
        System.out.println(b);
        //ERROR because it is out of range of byte, so explicit cast need to be provided by the user.
        byte c = (byte) 128;
        
        System.out.println(c);
    }
}

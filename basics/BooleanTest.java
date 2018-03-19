package basics;

/**
 * @author Ramesh BG
 *
 */
public class BooleanTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Boolean trueBoolean = Boolean.valueOf("true");
        System.out.println(trueBoolean);
        
        Boolean helloBoolean = Boolean.valueOf("hello");
        System.out.println(helloBoolean);
        
        Boolean rameshBoolean = Boolean.valueOf("ramesh");
        System.out.println(rameshBoolean);
        
        Boolean anyBoolean = Boolean.valueOf("any");
        System.out.println(anyBoolean);
        
        Boolean falseBoolean = Boolean.valueOf("false");
        System.out.println(falseBoolean);
    }
}
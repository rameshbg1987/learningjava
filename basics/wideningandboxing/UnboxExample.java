package basics.wideningandboxing;

/**
 * @author Ramesh BG
 *
 */
public class UnboxExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer a = 5;
        UnboxExample unboxExample = new UnboxExample();
        unboxExample.method(a);
    }
    
    public void method(int a) {
        System.out.println(a);
    }
    
    public void method(long a) {
        System.out.println("long primitive reached");
    }
}

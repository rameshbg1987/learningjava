package basics.wideningandboxing;

/**
 * @author Ramesh BG
 *
 */
public class BoxingAndWidening {

    /**
     * Example to show how int can be converted to Object.
     * 
     * step 1: int converted to Integer
     * step 2: Integer converted to Object (IS-A)
     * 
     */
    
    public static void main(String[] args) {
        int a = 5;
        BoxingAndWidening boxingAndWidening = new BoxingAndWidening();
        boxingAndWidening.method(a);
    }
    
    public void method(Object a) {
        System.out.println("reached Object");
    }
}

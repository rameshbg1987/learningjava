package basics.wideningandboxing;

/**
 * @author Ramesh BG
 *
 */
public class WideningAndBoxing {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * Widening And Boxing will not work for Primitive since it's a two step process.
         * e.g. conversion from int to Long won't work.
         * 
         *  steps
         *  1. int has to be converted to long.
         *  2. long has to be converted to Long.
         *  hence the compiler error
         *  commenting out the method call since it won't compile.
         */
        
        WideningAndBoxing wideningAndBoxing = new WideningAndBoxing();
        
        int intValue = 5;
        /*
         * purposely commented since it won't compile.
         */
//        wideningAndBoxing.method(intValue);
    }
    
    public void method(Long value) {
        System.out.println("Long Wrapper reached");
    }
}

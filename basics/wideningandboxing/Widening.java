package basics.wideningandboxing;

/**
 * @author Ramesh BG
 *
 */
public class Widening {

    /**
     * @param args
     * 
     * Overloaded methods testing
     */
    public static void main(String[] args) {
        Widening widening = new Widening();

        System.out.println("calling long primitive");
        widening.method(5L);
        System.out.println();

        System.out.println("calling Long AutoBoxing");
        widening.method(Long.valueOf(5));

        System.out.println("calling integer primitive");
        widening.method(5);
        System.out.println();

        System.out.println("calling Integer AutoBoxing");
        widening.method(Integer.valueOf(46));
        System.out.println();

        System.out.println("calling byte primitive");
        widening.method((byte) 5);
        System.out.println();

        System.out.println("calling Byte AutoBoxing");
        byte byteValue = 120;
        widening.method(Byte.valueOf(byteValue));
        System.out.println();

    }

    public void method(long a) {
        System.out.println("long primitive reached");
    }

    public void method(int a) {
        System.out.println("int primitive reached");
    }

    public void method(Integer a) {
        System.out.println("Integer autoboxing reached");
    }

    public void method(Byte a) {
        System.out.println("Byte autoboxing reached");
    }
}

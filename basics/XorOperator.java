package basics;

/**
 * @author Ramesh BG
 *
 */
public class XorOperator {

    public static void main(String[] args) {
        
        boolean a = true ^ false;
        boolean b = false ^ true;
        boolean c = false ^ false;
        boolean d = true ^ true;
        System.out.println("true^false = "+a);
        System.out.println("false^true = "+b);
        System.out.println("false^false = "+c);
        System.out.println("true^true = "+d);
    }
}

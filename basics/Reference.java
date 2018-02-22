package basics;

/**
 * @author Ramesh BG
 *
 */
public class Reference {

    /**
     * == operator is used to compare the values in bits
     * so 
     * 1. float 5.0 is equal to integer 5
     * 2. integer 5 is equal to Long integer 5
     * 3. float 5.0 is equal to Long integer 5
     */
    public static void main(String[] args) {
        System.out.println(5==5L);
        System.out.println(5==5.0);
        System.out.println(5.0==5L);
    }
}

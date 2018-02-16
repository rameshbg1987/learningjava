package basics;

/**
 * @author Ramesh BG
 *
 */
public class Wrapper {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer cachedValue = Integer.valueOf(12);
        Integer newInteger = new Integer(12);
        if (newInteger == cachedValue) {
            System.out.println("both are equal");
        } else {
            System.out.println("both are not equal");
        }

        Long long1 = new Long(21);
        Long long2 = new Long("21");
        if (long1.equals(long2)) {
            System.out.println("both longs are equal");
        }
        
        long parseLong = Long.parseLong("23", 10);
        System.out.println(parseLong);
        System.out.println(long1.shortValue());
        System.out.println(long1.floatValue());
        System.out.println(long1.doubleValue());
        System.out.println(long1.intValue());
        System.out.println(long1.byteValue());
        
        
        //use of decode function
        Integer decode = Integer.decode("016");
        System.out.println("decoded value"+decode);
        
        //UNBOXING
        Character character = new Character((char) 34);
        System.out.println(character);
        
        //caching from -128 to +127
        Integer valueOf = Integer.valueOf(127);
        Integer valueOf2 = Integer.valueOf(127);
        if(valueOf == valueOf2) {
            System.out.println("both integers are equal");
        }
        
        //No caching from +128
        
        Integer valueOf3 = Integer.valueOf(128);
        Integer valueOf4 = Integer.valueOf(128);
        if(valueOf3==valueOf4) {
            System.out.println("both integers are not equal");
        }
        
        Boolean valueOf5 = Boolean.valueOf("hello");
        System.out.println("value of 5 is "+valueOf5);
    }
}
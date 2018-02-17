package basics;

/**
 * @author Ramesh BG
 *
 */
public class Cast {

    /**
     * @param args
     */
    public static void main(String[] args) {
        byte a = 45;
        byte b = (byte) 1000;
        char c = 45;
        float d = 45;
        
        /**
         * by default decimal numbers are double, in order to convert into float
         * we have to append f to decimal value.
         */
        float f = 45.0f;
        
        /**
         *  90 is an integer value can be put into double container.
         */
        double e = 90;
        
    }
}
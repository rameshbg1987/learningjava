package basics;

/**
 * @author Ramesh BG
 *
 */
public class ArrayBasics {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 
         * a_ref is a reference to an array object which holds 10 integers.
         * array of 10 integers is an object in the heap.
         */
        int[] a_ref = new int[10];
        /**
         * when an array is constructed default value of 0 is assigned to each
         * index so 10 zero's will be printed as output when below code gets
         * executed.
         */

        for (int i = 0; i < a_ref.length; i++) {
            System.out.println(a_ref[i]);
        }

        a_ref[0] = 100;
        a_ref[9] = 56;

        for (int i = 0; i < a_ref.length; i++) {
            System.out.println(a_ref[i]);
        }

        MyInterface[] myInterface = new MyInterface[10];
        myInterface[0] = new One();
        myInterface[1] = new Two();

        for (int i = 0; i < myInterface.length; i++) {
            System.out.println(myInterface[i]);
        }
    }
}

interface MyInterface {

}

class One implements MyInterface {

}

class Two implements MyInterface {

}
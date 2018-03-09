package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class ArrayListNArray {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Array and List are SEPARATE from one another.
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        String[] emptyArray = new String[2];
        String[] array = list.toArray(emptyArray);
        /**
         * toArray() creates a copy of array instead of returning existing
         * array.
         * 
         */
        list.set(0, "this");
        System.out.println(list);
        System.out.println(Arrays.toString(array));

        // Array and List are NOT SEPARATE from one another.
        // if you modified one it will be reflected in another.
        String[] stringArray = new String[] { "a", "b" };
        List<String> asList = Arrays.asList(stringArray);
        asList.set(0, "xyz");
        System.out.println("modified array " + Arrays.toString(stringArray));
        System.out.println("modified list " + asList);

    }
}
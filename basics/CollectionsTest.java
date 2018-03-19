package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class CollectionsTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> firstList = new ArrayList<String>();
        firstList.add("hello");
        firstList.add("world");
        firstList.add("this");
        firstList.add("is");
        firstList.add("ramesh");
        Collections.sort(firstList);
        System.out.println(firstList);
        System.out.println(Collections.binarySearch(firstList, "hello"));
        System.out.println(Collections.binarySearch(firstList, "ramesh"));
        Collections.fill(firstList, "a");
        System.out.println(firstList);
        System.out.println("size of first list size is " + firstList.size());

        List<String> secondList = new ArrayList<String>(
                Collections.nCopies(firstList.size(), null));
        System.out.println("size of second list is " + secondList.size());
        Collections.copy(secondList, firstList);
        System.out.println(secondList);
    }
}
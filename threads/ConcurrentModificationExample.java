package threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class ConcurrentModificationExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("ab");
        strings.add("cd");
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("ef");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            String next = iterator.next();
            System.out.println(next);
        }
    }
}

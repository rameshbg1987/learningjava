package basics;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ramesh BG
 *
 */
public class ListIteratorTest {

    List<String> list = new ArrayList<String>();
    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        list.add("hello");
        list.add("world");
        list.add("this");
        list.add("is");
        list.add("ramesh");
        list.add("how");
        list.add("are");
        list.add("you");
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void iterateListInForwardDirection() {
        System.out.println("\n\nPrinting in Forward Direction");
        //index starts from 2, so it should print "this, is, ramesh, how, are ,you"
        ListIterator<String> listIterator = list.listIterator(2);
        while (listIterator.hasNext()) {
            String string = listIterator.next();
            System.out.println(string);
        }
    }
    
    @Test
    public void iterateListInBackwardDirection() {
        System.out.println("Printing in Backward Direction");
        ListIterator<String> listIterator = list.listIterator(5);
        while(listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println(previous);
        }
    }
}
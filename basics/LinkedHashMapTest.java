package basics;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ramesh BG
 *
 */
public class LinkedHashMapTest {

    LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 10; i++) {
            linkedHashMap.put(i, String.valueOf(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        linkedHashMap.clear();
    }

    @Test
    public void iterateLinkedHashMap() {
        Set<Entry<Integer, String>> entrySet = linkedHashMap.entrySet();
        for (Iterator<Entry<Integer, String>> iterator = entrySet
                .iterator(); iterator.hasNext();) {
            Entry<Integer, String> entry = iterator.next();
            System.out.println("Key is " + entry.getKey() + " Value is "
                    + entry.getValue());
        }
    }
}

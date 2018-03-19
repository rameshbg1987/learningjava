package basics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Ramesh BG
 *
 */
public class HashMapTest {

    HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i <= 10; i++) {
            hashMap.put(i, String.valueOf(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        // clear hashmap
        hashMap.clear();
    }

    @Test
    public void getValue() {
        System.out.println(hashMap);
        String string = hashMap.get(4);
        System.out.println(string);
        Assert.assertTrue(string.equals("4"));
    }

    @Test
    public void iterateHashMap() {
        System.out.println(
                "Take a look at the order of elements when printing hashmap it is random order");
        Set<Entry<Integer, String>> entrySet = hashMap.entrySet();
        Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<java.lang.Integer, java.lang.String> entry = (Map.Entry<java.lang.Integer, java.lang.String>) iterator
                    .next();
            System.out.println(
                    "Key " + entry.getKey() + " Value " + entry.getValue());
        }
    }

    @Test
    public void printKeys() {
        Set<Integer> keySet = hashMap.keySet();
        for (Integer integer : keySet) {
            System.out.println("Key is " + integer);
        }
    }

    @Test
    public void printValues() {
        Collection<String> values = hashMap.values();
        for (Iterator<String> iterator = values.iterator(); iterator
                .hasNext();) {
            String string = iterator.next();
            System.out.println("Value is " + string);
        }
    }
}
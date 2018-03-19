package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class GenericSuperKeywordTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenericSuperKeywordTest genericSuperKeywordTest = new GenericSuperKeywordTest();
        List<Animal> arrayList = new ArrayList<Animal>();
        arrayList.add(new Animal("hello"));
        genericSuperKeywordTest.getType(arrayList);
    }
    
    private  void getType(List<? super Animal> list) {
        /*
         * following is not possible
         */
        //list = new ArrayList<Cat>();
        list.add(new Cat("cat"));
        System.out.println(list);
    }
}
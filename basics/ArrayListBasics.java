package basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Ramesh BG
 *
 */
public class ArrayListBasics {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayListBasics arrayListBasics = new ArrayListBasics();
        arrayListBasics.arrayStringAddition();
        arrayListBasics.arrayListPersonAddition();
        arrayListBasics.arrayListPersonWithToStringAddition();
        arrayListBasics.arrayListIndexAdditionOperation();
        arrayListBasics.arrayListIndexOperations();
        arrayListBasics.subList();
        arrayListBasics.iteratorOperation();
        arrayListBasics.iteratorRemoveOperation();
        arrayListBasics.listIteratorOperation();
        arrayListBasics.retainAllOperation();
    }

    private void retainAllOperation() {
        System.out.println("Retain All Operation\n\n");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        } 
        
        list.retainAll(list.subList(2, 6));
        System.out.println("List After RetainAll Operation "+list);
        
    }

    private void listIteratorOperation() {
        System.out.println("List Iterator Remove Operation\n\n");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        ListIterator<String> listIterator = list.listIterator(list.size());
        while(listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    private void iteratorRemoveOperation() {
        System.out.println("Iterator Remove Operation\n\n");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        Iterator<String> iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }

    private void iteratorOperation() {
        System.out.println("List Iterator Operation\n\n");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            System.out.println(string);
        }
    }

    private void subList() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("this");
        list.add("is");
        list.add("ramesh");
        System.out.println();
        System.out.println();
        System.out.println("Entire List is " + list);
        List<String> subList = list.subList(1, 4);
        System.out.println("SubList from index 1 to 4");
        System.out.println(subList);
        System.out.println("sublist size is " + subList.size());
        subList.add(3, "x");
        System.out.println("after adding element is " + subList);

    }

    private void arrayListIndexOperations() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(String.valueOf(i));
        }
        list.forEach(a -> System.out.println(a));

        System.out.println(
                "index position is " + list.indexOf(String.valueOf(1)));
        System.out.println("get the object " + list.get(9));
        list.add(0, "hello");
        System.out.println(list);
    }

    private void arrayListIndexAdditionOperation() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add(0, "first");
        System.out.println("After adding first at index 0 position");
        System.out.println(list);
        System.out.println("size of arraylist is " + list.size());

        list.add(3, "xyz");
        System.out.println(list);
    }

    private void arrayListPersonWithToStringAddition() {
        List<PersonWithToString> personListWithToString = new ArrayList<PersonWithToString>();
        personListWithToString.add(new PersonWithToString("ramesh"));
        personListWithToString.add(new PersonWithToString("typing"));
        /**
         * since we have overrided toString() method in PersonWithToString class
         * toString() method of PersonWithToString will invoked when
         * List<PersonWithToString> is invoked in System.out.println() command.
         * 
         */
        System.out.println(personListWithToString);
    }

    private void arrayListPersonAddition() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person());
        personList.add(new Person());
        /**
         * since we have not overrided toString() method of Person class it will
         * invoke from java.lang.Object toString() method.
         */
        System.out.println(personList);
    }

    private void arrayStringAddition() {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("hello");
        arrayList.add("world");
        /**
         * check the output of toString() of ArrayList it will print the
         * contents in square brackets.
         */
        System.out.println(arrayList);
    }
}

class Person {

}

class PersonWithToString {

    private String name;

    public PersonWithToString(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
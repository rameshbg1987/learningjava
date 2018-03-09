package basics;

import java.util.ArrayList;
import java.util.List;

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
    }

    private void arrayListIndexAdditionOperation() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add(0, "first");
        System.out.println("After adding first at index 0 position");
        System.out.println(list);
        System.out.println("size of arraylist is "+list.size());
        
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
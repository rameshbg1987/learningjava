package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class GenericExtendsKeywordTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Cat> list = new ArrayList<Cat>();
        list.add(new Cat("cat 1"));
        list.add(new Cat("cat 2"));
        /*
         * if this step results in compilation error what is the use of ?extends
         * keyword need to check. //List<Animal> list = new ArrayList<Cat>();
         */

        GenericExtendsKeywordTest genericExtendsKeywordTest = new GenericExtendsKeywordTest();
        genericExtendsKeywordTest.method(list);
    }

    private void method(List<? extends Animal> list) {
        /*
         * "List<? extends Animal>" is read-only list    
         * only list.add(null) is allowed
         */
        for (Animal animal : list) {
            System.out.println(animal);
        }
    }
}

class Animal {
    private String name;

    public Animal(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animal name is ");
        stringBuilder.append(getName());
        return stringBuilder.toString();
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
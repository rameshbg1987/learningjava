package basics;

import java.util.HashSet;
import java.util.Random;

/**
 * @author Ramesh BG
 *
 */
public class HashSetBasics {

    public static void main(String[] args) {
        HashSetBasics hashSetBasics = new HashSetBasics();
        hashSetBasics.populateHashSet();
        hashSetBasics.getterMethod();
        hashSetBasics.removeMethod();
        hashSetBasics.clearMethod();
        hashSetBasics.equalsMethodTest();
    }

    private void clearMethod() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        System.out.println("HashSet Before Calling Clear Method");
        System.out.println(hashSet);
        hashSet.clear();
        System.out.println("HashSet After Calling Clear Method");
        System.out.println(hashSet);
    }

    private void populateHashSet() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            hashSet.add(random.nextInt(100));
        }
        System.out.println("After adding to HashSet");
        System.out.println(hashSet);
    }

    private void getterMethod() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int nextValue = random.nextInt(100);
            if (hashSet.contains(nextValue)) {
                System.out.println("Contains " + nextValue);
            } else {
                System.out.println("Does Not Contains " + nextValue);
            }
        }
    }

    private void removeMethod() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (hashSet.add(90)) {
            System.out.println("Value 90 added successfully");
        } else {
            System.out.println("Value 90 already present");
        }
        System.out.println(hashSet);
        if (hashSet.contains(90)) {
            System.out.println("Contains 90");
        }
        if (hashSet.remove(90)) {
            System.out.println("Value 90 removed successfully");
        }
    }

    private void equalsMethodTest() {
        class Person {
            String name;
            String address;
            int id;

            public Person(String name, String address, int id) {
                super();
                this.name = name;
                this.address = address;
                this.id = id;
            }

            public int hashCode() {
                return name.length();
            }

            public boolean equals(Object obj) {
                if (obj instanceof Person) {
                    Person personObj = (Person) obj;
                    return personObj.address.equals(address)
                            && personObj.name.equals(name)
                            && personObj.id == id;
                }
                return false;
            }
        }
        HashSet<Person> hashSet = new HashSet<Person>();
        hashSet.add(new Person("ramesh", "doddaballapur", 1234));
        hashSet.add(new Person("pavani", "ramachandrapuram", 5678));
        
        if(hashSet.contains(new Person("ramesh", "doddaballapur", 1234))) {
            System.out.println("Ramesh Person Object is present in HashSet");
        } else {
            System.out.println("Ramesh Person Object is not present in HashSet");
        }
    }
}
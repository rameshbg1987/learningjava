package basics;

import java.util.LinkedList;

/**
 * @author Ramesh BG
 *
 */
public class LinkedListBasics {

    private LinkedList<String> linkedList = new LinkedList<String>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedListBasics linkedListBasics = new LinkedListBasics();
        linkedListBasics.createLinkedList();
        linkedListBasics.addFirst();
    }
    
    private void addFirst() {
        System.out.println("Before Adding element at first");
        linkedList.addFirst("hello");
        System.out.println("After adding element at first ");
        System.out.println(linkedList);
    }

    private void createLinkedList() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i, String.valueOf(i));
        }
        System.out.println(linkedList);
    }
}

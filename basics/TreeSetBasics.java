package basics;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Ramesh BG
 *
 */
public class TreeSetBasics {

    TreeSet<String> treeSet = new TreeSet<String>();

    public TreeSetBasics() {
        populateTreeSet();
    }

    private void headSetCalculation() {
        System.out.println(treeSet.headSet("D"));
    }

    private void tailSetCalculation() {
        System.out.println(treeSet.tailSet("D"));
    }

    // lower is strictly works as < (less than)
    private void lowerCalculation() {
        System.out.println(treeSet.lower("D"));
    }

    // floor works as <= (less than or equal to)
    private void floorCalculation() {
        System.out.println(treeSet.floor("D"));
    }

    private void ceilingCalculation() {
        System.out.println(treeSet.ceiling("D"));
    }

    private void higherCalculation() {
        System.out.println(treeSet.higher("D"));
    }

    public static void main(String[] args) {
        TreeSetBasics treeSetBasics = new TreeSetBasics();
        treeSetBasics.headSetCalculation();
        treeSetBasics.tailSetCalculation();
        treeSetBasics.lowerCalculation();
        treeSetBasics.floorCalculation();
        treeSetBasics.ceilingCalculation();
        treeSetBasics.higherCalculation();
        treeSetBasics.subSetCalculation();
        treeSetBasics.pollFirstCalculation();
    }

    private void pollFirstCalculation() {
        System.out.println("Complete TreeSet "+treeSet);
        System.out.println("Before Polling First");
        System.out.println(treeSet.pollFirst());
        System.out.println("After Polling First");
        System.out.println(treeSet);
    }

    private void subSetCalculation() {
        // exclusive of toElement (end element)
        SortedSet<String> subSet = treeSet.subSet("B", "E");
        System.out.println("subSet Calculation " + subSet);
        System.out.println("subSet Calculation inclusive of toElement "
                + treeSet.subSet("B", true, "E", true));
    }

    private void populateTreeSet() {
        for (int i = 0; i < 10; i++) {
            treeSet.add(Character.toString((char) (65 + i)));
        }
        System.out.println(treeSet);
    }
}

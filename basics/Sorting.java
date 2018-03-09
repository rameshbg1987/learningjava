package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ramesh BG
 *
 */
public class Sorting {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.arrayListStringSorting();
        sorting.arrayListStudentSortingOnName();
        sorting.arrayListStudentSortingOnId();
    }

    private void arrayListStudentSortingOnId() {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("x", 2));
        list.add(new Student("z", 3));
        list.add(new Student("a", 1));
        System.out.println("Before Sorting Comparator by ID " + list);
        Comparator<Student> comparatorById = new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getId() < o2.getId())
                    return -1;
                if (o1.getId() == o2.getId())
                    return 0;
                if (o1.getId() > o2.getId())
                    return 1;
                return 0;
            }
        };
        Collections.sort(list, comparatorById);
        System.out.println("After Sorting Comparator by ID " + list);
    }

    private void arrayListStudentSortingOnName() {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("x"));
        list.add(new Student("z"));
        list.add(new Student("a"));
        System.out.println("Before Sorting on Name " + list);
        Collections.sort(list);
        System.out.println("After Sorting on Name " + list);
    }

    private void arrayListStringSorting() {
        List<String> list = new ArrayList<>();
        list.add("z");
        list.add("y");
        list.add("x");
        System.out.println("Before Sorting on String" + list);
        Collections.sort(list);
        System.out.println("After Sorting on String " + list);
    }
}

class Student implements Comparable<Student> {
    private String name;

    private int id;

    public String getName() {
        return this.name;
    }

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * @param string
     */
    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "name= " + this.name + " id= " + this.id;
    }

    public int getId() {
        return this.id;
    }
}
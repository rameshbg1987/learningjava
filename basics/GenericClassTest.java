package basics;

/**
 * @author Ramesh BG
 *
 */
public class GenericClassTest<T> {

    public static void main(String[] args) {
        GenericClass<Integer> genericInteger = new GenericClass<Integer>();
        genericInteger.printType(5);

        GenericClass<Double> genericDouble = new GenericClass<Double>();
        genericDouble.printType(5.0);

        GenericClass<Float> genericFloat = new GenericClass<Float>();
        genericFloat.printType(5.0f);
        
        GenericClass<Student> genericStudent = new GenericClass<Student>();
        genericStudent.printType(new Student("ramesh", 1234));
    }
}

class GenericClass<T> {

    public void printType(T t) {
        System.out.println("This of type " + t.getClass() +" and value is "+t);
    }
}


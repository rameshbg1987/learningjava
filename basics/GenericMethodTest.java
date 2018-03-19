package basics;

/**
 * @author Ramesh BG
 *
 */
public class GenericMethodTest {

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.getType(Integer.valueOf(9));
        genericMethod.getType(new Student("ramesh"));
        genericMethod.getType("hello");
    }
}
class GenericMethod {
    
    public <T> void getType(T t) {
        System.out.println("method name is getType and argument received type is "+t.getClass());
    }
}

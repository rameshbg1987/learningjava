package basics;

/**
 * @author Ramesh BG To test whether Constructor Name can be used for both
 *         Constructor as well as method.
 */
public class ConstructorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new SecondClass().method();
    }

    void ConstructorTest() {
        System.out.println("hello world");
    }

}

class SecondClass {
    void SecondClass() {

    }

    void method() {
        System.out.println("method name");
    }
}

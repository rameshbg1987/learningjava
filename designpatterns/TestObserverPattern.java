package designpatterns;

/**
 * @author Ramesh BG
 *
 */
public class TestObserverPattern {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer = new Observer();
        subject.registerListener(observer);
        subject.setA(10);
        subject.setA(100);
    }
}
package basics;

/**
 * @author Ramesh BG
 *
 */
public class ShallowCloneTest {

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowClass originalObj = new ShallowClass(5);
        ShallowClass clonedObj = (ShallowClass) originalObj.clone();
        if (originalObj == clonedObj) {
            System.out.println("Original and Cloned Object are Same");
        } else {
            System.out.println("Original and Cloned Object are DIFFERENT");
        }
        System.out.println(
                originalObj.getMemberClass() == clonedObj.getMemberClass());
    }
}

/*
 * class must implement Cloneable Marker Interface otherwise
 * CloneNotSupportedException will be thrown.
 */
class ShallowClass implements Cloneable {
    private int a;

    private MemberClass memberClass;

    /**
     * @param a
     */
    public ShallowClass(int a) {
        this.a = a;
        this.memberClass = new MemberClass();
    }

    public int getA() {
        return this.a;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public MemberClass getMemberClass() {
        return this.memberClass;
    }
}

class MemberClass {

}
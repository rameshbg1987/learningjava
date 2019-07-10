package basics;
public class ShadowTest {
	int x;
	public static void main(String[] args) {
		int x = 5;
		System.out.println();
		System.out.print(new ShadowTest().x);
	}
}

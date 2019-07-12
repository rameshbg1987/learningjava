package basics;

public class GCD {

	public static void main(String[] args) {
		System.out.println("GCD is " + gcd(9, 3));
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		int r = a % b;
		if (r == 0) {
			return b;
		}
		return gcd(b, r);
	}

}

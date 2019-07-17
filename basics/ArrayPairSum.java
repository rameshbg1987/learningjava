package basics;

/**
 * @author rbgangad
 *
 */
public class ArrayPairSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int left = 0;
		int right = array.length - 1;

		int sum = 6;

		while (true) {
			if (array[left] + array[right] == sum) {
				break;
			}
			if (array[left] + array[right] < sum) {
				left++;
			} else {
				right--;
			}
		}

		System.out.printf("%d + %d = %d\n", array[left], array[right], array[left] + array[right]);
		System.out.println("LEFT is " + left + " RIGHT is " + right);
	}

}

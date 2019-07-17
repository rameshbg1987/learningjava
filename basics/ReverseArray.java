package basics;
import java.util.Arrays;

/**
 * @author rbgangad
 *
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		reverse(array);

		int[] evenlengtharray = { 10, 20, 30, 40, 50, 60 };
		reverse(evenlengtharray);

		int[] oddlengtharray = { 10, 20, 30, 40, 50 };
		reverse(oddlengtharray);

	}

	private static void reverse(int[] array) {
		System.out.println("INITIAL ARRAY       " + Arrays.toString(array));
		int left = 0;
		int right = array.length - 1;
		while (true) {
			swap(array, left, right);
			left++;
			right--;
			if (right < left) {
				break;
			}
		}
		System.out.println("AFTER REVERSE ARRAY " + Arrays.toString(array));
	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}

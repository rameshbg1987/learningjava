package basics;
import java.util.Arrays;

/**
 * @author rbgangad
 *
 *         Move all zeros to start and 1's to end. Input: arr[] = {1, 2, 0, 4,
 *         3, 0, 5, 0} Output: = {0, 0, 0, 2, 4, 3, 5, 1}
 *
 */
public class MoveZeroAndOneToEnds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int array[] = { 1, 2, 0, 0, 0, 3, 6 };
		int array[] = {1, 2, 0, 4, 3, 0, 5, 0};

		int one_count = 0;

		System.out.println("INITIAL ARRAY:"+Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				one_count++;
			}
		}

		int non_zero_index = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0 && array[i] !=1) {
				array[non_zero_index++] = array[i];
			}
		}
		
		int one_count_start = 1;
		
		while(one_count_start <= one_count ) {
			array[non_zero_index++] = 1;
			one_count_start++;
		}
		
		for (int i = non_zero_index; i < array.length; i++) {
			array[non_zero_index++] = 0;
		}
		
		int nonZeroIndex = array.length - 1;
		for (int i = array.length -1; i > -1; i--) { 
			if(array[i] != 0) {
				array[nonZeroIndex] = array[i];
				nonZeroIndex--;
			}
		}
		
		while(nonZeroIndex > -1) {
			array[nonZeroIndex] = 0;
			nonZeroIndex--;
		}
		System.out.println("AFTER MOVING: "+Arrays.toString(array));
	}
}

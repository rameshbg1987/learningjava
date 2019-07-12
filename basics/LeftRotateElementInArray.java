package basics;

import java.util.Arrays;

public class LeftRotateElementInArray {

	public static void main(String[] args) {
		int rotationCount = 3;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Array before rotation is   " + Arrays.toString(array));
		leftRotate(array, rotationCount);
		System.out.printf("After %d rotations array is " + Arrays.toString(array), rotationCount);
	}

	private static void leftRotate(int[] array, int rotationCount) {
		for (int i = 1; i <= rotationCount; i++) {
			int temp = array[0];
			for (int j = 0; j < array.length - 1; j++) {
				array[j] = array[j + 1];
			}
			array[array.length - 1] = temp;
		}

	}
}

package basics;

import java.util.Arrays;

public class ArrayLeftShiftOperation {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int d = 4;
		System.out.println("BEFORE LEFT SHIFT " + Arrays.toString(array));
		rotate(array, 0, d - 1);
		rotate(array, d, array.length - 1);
		rotate(array, 0, array.length - 1);
		System.out.println("AFTER LEFT SHIFT  " + Arrays.toString(array));
		System.out.println();
	}

	private static void rotate(int[] array, int start, int end) {
		int i = start;
		int j = end;
		while (true) {
			if (i == j || j < i) {
				break;
			}
			swap(array, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

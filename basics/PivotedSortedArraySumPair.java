package basics;

public class PivotedSortedArraySumPair {

	public static void main(String[] args) {

		int[] array = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// int[] array = { 7, 8, 9, 10, 1, 2, 3, 4, 5 };
		int pivotIndex = findPivot(array, 0, array.length - 1);
		System.out.println(pivotIndex);
		findSum(12, array, pivotIndex);
	}

	private static int findPivot(int[] array, int low, int high) {

		if (high < low) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (array[mid] > array[mid + 1]) {
			return mid + 1;
		} else if (array[low] > array[mid]) {
			return findPivot(array, low, mid);
		}
		return findPivot(array, mid + 1, high);
	}

	private static void findSum(int requiredSum, int[] array, int pivotIndex) {
		int startIndex = pivotIndex;
		int endIndex = pivotIndex - 1;

		while (true) {
			int currentSum = array[startIndex] + array[endIndex];
			if (currentSum == requiredSum) {
				System.out.printf("%d + %d = %d STARTINDEX=%d ENDINDEX=%d", array[startIndex], array[endIndex],
						array[startIndex] + array[endIndex], startIndex, endIndex);
				break;
			} else if (currentSum < requiredSum) {
				startIndex = (startIndex + 1) % (array.length);
			} else {
				endIndex = (endIndex - 1) % (array.length);
			}
		}
	}
}
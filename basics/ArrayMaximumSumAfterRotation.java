package basics;

public class ArrayMaximumSumAfterRotation {

	public static void main(String[] args) {

		int[] array = { 8, 3, 1, 2 };

		int arraySum = 0;

		for (int i = 0; i < array.length; i++) {
			arraySum = arraySum + array[i];
		}

		int arrayRotationVal = 0;

		for (int i = 0; i < array.length; i++) {
			arrayRotationVal = arrayRotationVal + i * array[i];
		}

		int temp = arrayRotationVal;
		for (int i = array.length - 1; i > 0; i--) {
			temp = temp + arraySum - array.length * array[i];
			if (temp > arrayRotationVal) {
				arrayRotationVal = temp;
			}
		}
		System.out.println("Maximum value is " + arrayRotationVal);
	}
}

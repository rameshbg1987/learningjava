package march9th2021;

public class TopThreeElements {

	public static void main(String[] args) {

		int[] array = {12, 13, 1, 10, 34, 1 };

		int first = array[0], second = -1, third = -1;

		for (int each_element : array) {

			if (each_element > first) {
				third = second;
				second = first;
				first = each_element;
			} else if (each_element > second) {
				third = second;
				second = each_element;
			} else if (each_element > third) {
				third = each_element;
			}
		}
		
		System.out.println("First="+first+" Second="+second+" Third="+third);

	}
}

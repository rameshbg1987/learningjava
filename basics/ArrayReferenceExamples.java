package basics;

public class ArrayReferenceExamples {

	public static void main(String[] args) {
		ArrayReferenceExamples arrayReferenceExamples = new ArrayReferenceExamples();
		arrayReferenceExamples.invalidArrayReference();
		arrayReferenceExamples.validArrayReference();
	}

	public void validArrayReference() {
		Car[] cars = new Car[10];
		cars[0] = new Car();
		cars[1] = new Honda();

		Car[] hondaCars = new Honda[10];
		hondaCars[0] = new Honda();
		hondaCars[1] = new Honda();
	}

	public void invalidArrayReference() {
		// this is not possible.
		/**
		 * commenting since it is a compilation error.
		 */
		//int[] ints = new byte[10];
	}
}

class Car {

}

class Honda extends Car {

}
package core;

import java.util.Scanner;

public class Massive {
	private int quotient;

	public static void main(String[] args) {

		Massive massive1 = new Massive();
		massive1.findAQuotient();
		massive1.fillInMassive();
		massive1.printFifthMassiveElement();

	}

	public void findAQuotient() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Fill in dividend and divider");
		try {
			int dividend = scanner.nextInt();
			int divider = scanner.nextInt();
			quotient = dividend / divider;
			System.out.println("The quotient is " + quotient);

		} catch (ArithmeticException e) {
			System.out.println("Division for a 0 is forbidden");
		}
	}

	public void fillInMassive() {
		int[] massive = new int[quotient];
		for (int i = 0; i < massive.length; i++) {
			massive[i] = (int) (Math.random() * 10);
			System.out.println(massive[i]);
		}
	}
	
	public void printFifthMassiveElement() {
		try {
		int[] massive = new int[quotient];
		System.out.println("The fifth element is " + massive[4]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("There is no fifth element in massive");
		}
	}
}

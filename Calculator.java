package workingWithLoops;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		final int SENTINAL = 0;
		int number;
		int total = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the addition calclulator.\n");
		System.out.print("Enter the first number" + " or 0 for the total > ");
		do {
			number = scan.nextInt();
			total += number;

			System.out.print("Enter the next number" + " or 0 for the total > ");
			//number = scan.nextInt();
		} while (number != SENTINAL);
		System.out.println("The total is " + total);
		scan.close();
	}// main
}// Looping
package workingWithLoops;

import java.util.Scanner;

public class Sum5Numbers {

	public static void main(String[] args) {
		int number;
		int total = 0;

		Scanner scan = new Scanner(System.in);
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter an integer > ");
			number = scan.nextInt();
			total += number; //add input to total
		}
		
		System.out.println("The total is " + total);
		scan.close();
	}// main
}// Looping
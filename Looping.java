package workingWithLoops;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Looping {

	public static void main(String[] args) throws FileNotFoundException {
		//for calculating the scores, percent of passing grades, and average score
		final int SENTINAL = -1;
		int countScores = 0, countPassed = 0;
		int score;

		File inputFile = new File("input.txt");
		Scanner scan = new Scanner(inputFile);

		System.out.println("This program counts the number of passing test scores.");
		score = scan.nextInt();
		
		//for calculating maximum and minimum grades
		//sets max and min grades to the first score, and then adjusts below
		int maxGrade = score, minGrade = score;
		if (!scan.hasNextLine()) {
			System.out.println("There are no scores. Please enter scores and try again.");
		}
		if (scan.hasNextLine()) {

			while (score != SENTINAL) {
				//if the next score is higher than max, that score is assigned to max
				if (score > maxGrade)
					maxGrade = score;
				//if next score is lower than min, that score is assigned to min
				if (score < minGrade)
					minGrade = score;
				//counts the passing grades
				if (score >= 60)
					countPassed++;

				countScores++;

				score = scan.nextInt();
			} // while
			//print the number of scores, max grade, and minimum grade
			System.out.println("You entered " + countScores + " scores");
			System.out.println("The number of passing test scores is " + countPassed + "\n");
			
			//print the average score, or print that there are no scores.
			if (countScores != 0) {
				DecimalFormat percent = new DecimalFormat("0.0%");
				System.out.println(
						percent.format((double) (countPassed) / countScores) + 
						" of the class passed the test.");
				System.out.println("The minimum grade is " + minGrade);
				System.out.println("The maximum grade is " + maxGrade);
			}else {
				System.out.println("There are no scores entered.");
			}// countScores

		}//if has next
		scan.close();
	}// main
}// Looping

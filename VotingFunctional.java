package icpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VotingFunctional {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ArrayList<String> votes = new ArrayList<>();

		for (;;) {
			String vote = scan.nextLine();
			if (vote.equals("#")) {
				break;
			} else {
				votes.add(vote);
			}
		}
		votes.stream().forEach(vote -> {

			int yes = (int) Arrays.asList(vote.split("")).stream().filter(str -> str.equalsIgnoreCase("Y")).count();
			int no = (int) Arrays.asList(vote.split("")).stream().filter(str -> str.equalsIgnoreCase("N")).count();
			int absent = (int) Arrays.asList(vote.split("")).stream().filter(str -> str.equalsIgnoreCase("A")).count();

			if (absent > (vote.length() / 2)) {
				System.out.println("need quorum");
			} else if (yes > no) {
				System.out.println("yes");
			} else if (no > yes) {
				System.out.println("no");
			} else {
				System.out.println("tie");
			}

		});
		scan.close();
	}// main

}// Voting

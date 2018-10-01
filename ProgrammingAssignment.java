//A Password Protection Program by Guy Batton
//Copyright 2018. All rights reserved.
//I actually don't know what rights are reserved with this,
//so maybe there aren't any.

package workingWithSelection;

import javax.swing.JOptionPane;

public class ProgrammingAssignment {

	public static void main(String[] args) {
		//take in the prospective password
		String pass = JOptionPane.showInputDialog("Please enter your password: ");
		//String to read into JOptionPane. Improves readability and reusability.
		String reject = "Password strength is weak. Try again."; 
		
		//constants for comparison and maintainability
		char last = pass.charAt(pass.length() - 1); //last character
		char secondLast = pass.charAt(pass.length() - 2);
		char thirdLast = pass.charAt(pass.length() - 3);
		
		char first = pass.charAt(0); //first character
		char second = pass.charAt(1);
		char third = pass.charAt(2);
		
		//the parameters to pass.
		
		// contains at least 10
		if (pass.length() >= 10) {
			// contains a special character
			if (pass.contains("!") || pass.contains("#") || pass.contains("$")) {
				// first character not a special character
				if (pass.charAt(0)  != '!' && pass.charAt(0) != '#' && pass.charAt(0) != '?') {
					// does not contain a space 
					if (pass.contains(" ") == false) {
						// all of first three characters are not the same
						if (first != second || first != third) {
							// all of last three characters are not the same
							if (last != secondLast || last != thirdLast) {
								JOptionPane.showMessageDialog(null, "Accepted.", "Password",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, reject, "Password",
										JOptionPane.INFORMATION_MESSAGE);
							}// last three not same
						} else {
							JOptionPane.showMessageDialog(null, reject, "Password",
									JOptionPane.INFORMATION_MESSAGE);
						}// first three not same
					} else {
						JOptionPane.showMessageDialog(null, reject, "Password",
								JOptionPane.INFORMATION_MESSAGE);
					}// not contain space
				} else {
					JOptionPane.showMessageDialog(null, reject, "Password",
							JOptionPane.INFORMATION_MESSAGE);
				}// not start with ! # ?
			} else {
				JOptionPane.showMessageDialog(null, reject, "Password", JOptionPane.INFORMATION_MESSAGE);
			}// contains ! # $
		} else {
			JOptionPane.showMessageDialog(null, reject, "Password", JOptionPane.INFORMATION_MESSAGE);
		}// >=10

	}// main

}// Programming

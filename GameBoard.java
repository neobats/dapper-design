package battleship;

public class GameBoard {
	private final int BOARDSIZE = 10;
	private final int TOTAL_HITS = 12;
	private char[][] board = new char[BOARDSIZE][BOARDSIZE];
	private int plays;
	private static int hits;

	///////////////// Public Methods
	
	public GameBoard() {
		for (int row = 0; row < BOARDSIZE; row++) {
			for (int col = 0; col < BOARDSIZE; col++) {
				board[row][col] = '-';
			}
		}
	}// default contructor

	//modified to call fillOrient, a method below that fills a
	//game board with a ship based upon its orientation
	//fillOrient not only fills the ship, but returns true or false if the operation
	//was successful.
	public boolean placeShip(char shipType, int row, int col, char orient) {
		boolean ship = false;
		switch (shipType) {
		case 'S':
			ship = fillOrient(orient, shipSpaces(shipType), row, col, shipType);
		case 'B':
			ship = fillOrient(orient, shipSpaces(shipType), row, col, shipType);
		case 'A':
			ship = fillOrient(orient, shipSpaces(shipType), row, col, shipType);
		}// switch
		return ship;
	}// placeShip
	
	public boolean play(int row, int col) {
		if (validShot(row, col)) {
			if (hasShip(row, col) && board[row][col] != 'X') {
				board[row][col] = 'X';
				hits++;
				return true;
			} else if (!hasShip(row, col) && board[row][col] != '*') {
				board[row][col] = '*';
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}//play

	//returns true if the shot called is a valid shot
	public boolean validShot(int row, int col) {
		if (row < BOARDSIZE && col < BOARDSIZE) {
			return true;
		} else {
			return false;
		}
	}// validShot
	
	//returns true if all ships have been sunk
	public boolean allSunk() {
		if (hits == TOTAL_HITS)
			return true;
		else
			return false;
	}// allSunk
	
	//displays the gameboard to the console
	public boolean showBoard() {
		char label = 'A';
		
		System.out.println("1 2 3 4 5 6 7 8 9 10");
		for(int row = 0; row < BOARDSIZE; row++) {
			for (int col = 0; col < BOARDSIZE; col++) {
				System.out.print( "" + (label + row) + board[row][col] + " ");
			}
				System.out.println();
		}
		return true;
	}//showBoard
	
	
	///////////////Private Helper Methods

	// This method checks to see if there is an unhit ship at the location called.
	// Used by fillOrient, and thus by placeShip.
	private boolean hasShip(int row, int col) {
		boolean shipHere = false;
		if (board[row][col] == 'S' || board[row][col] == 'B' || board[row][col] == 'A') {
			shipHere = true;
		}
		return shipHere;
	}// hasShip
	
	// This method fills the board with the ship's type if there is not already a
	// ship in
	// that location.
	// calls hasShip to check if a ship already exists.
	// Refactor this to include, if possible, a way to simplify the number of times hasShip needs to be called
	// and to take in shipSpaces as the parameter.
	// Otherwise, take in shipSpaces and call hasShip for the number of times up to shipSpaces.
	// Also, this would be better as two methods: one to fill the array, and
	// one to return true or false if it happened. That might mean just calling hasShip before and after.
	private boolean fillOrient(char orientation, int length, int r, int c, char type) {
		boolean filled = false;
		switch (orientation) {
		case 'H':
			if (!(hasShip(r, c) || hasShip(r, c + 1) || hasShip(r, c + 2))) {
				for (int i = 0; i <= length; i++) {
					board[r][c + i] = type;
				}
				filled = true;
			} // if
		case 'V':
			if (!(hasShip(r, c) || hasShip(r + 1, c) || hasShip(r + 2, c))) {
			  for (int i = 0; i < length; i++) {
				  board[r + i][c] = type;
			  }
				filled = true;
			} // if
		}
		return filled;
	}// fillOrient
	
	//This method calculates the number of spaces that need to be filled when placing a ship
	private int shipSpaces(char ship) {
		if (ship == 'S') {
			return 3;
		} else if (ship == 'B') {
			return 4;
		} else if (ship == 'A') {
			return 5;
		} else {
			return 0;
		}//if/else
	}//shipSpaces

}// GameBoard
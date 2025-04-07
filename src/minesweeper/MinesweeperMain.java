package minesweeper;

import java.util.Scanner;

public class MinesweeperMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Variables to manage loop exit
		boolean bomb = false;
		boolean winner = false;
		
		//Variables to storage the user's coords
		int cordRows = 0;
		int cordColumns= 0;
		
		//Put the mines on the board
		Minesweeper.putMines();
		
		
		//Welcome the user
		System.out.println("Welcome to MineSweeper");
		do {
			//Print the board
			Minesweeper.printBoard();
			
			askCoordinateY();
			cordRows = changeToInt(sc.nextLine().toUpperCase().charAt(0));
			
			//Asking the coords
			askCoordinateX();
			cordColumns = sc.nextInt() - 1;
			sc.nextLine();
			
			
			

			
			//Seek for the mine
			if (Minesweeper.lookForMine(cordColumns, cordRows)) {
				bomb = true;
			} else {
				winner = Minesweeper.winner();
			}
		} while (!winner && !bomb);
		
		if(bomb) {
			System.out.println("YOU LOSE, STEPPED ON A BOMB");
		}
		
		if(winner) {
			System.out.println("YOU WIN!!!");
		}

		// Closing scanner
		sc.close();
	}
/**
 * Method that casts the param character to int
 * @param character Character that will be casted
 * @return casted number 
 */
	public static int changeToInt(char character) {
		return (int) (character - 'A');
	}

	/**
	 * Method that asks the user for the row number
	 */
	public static void askCoordinateX() {
		System.out.println("Enter column number");
	}

	/**
	 * Method that asks the user for the column number
	 */
	public static void askCoordinateY() {
		System.out.println("Enter row letter");
}

}

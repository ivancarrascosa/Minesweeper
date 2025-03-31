package minesweeper;

import java.util.Scanner;

public class MinesweeperMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);

		boolean boom = false;
		Minesweeper.printBoard();
		Minesweeper.putMines();
		Minesweeper.lookForMine(0, 0);
		Minesweeper.printBoard();
		
		
		
		
		
		sc.close();

	}
	
	public int changeToInt (char character) {
		return (int) character - 11;
	}

}

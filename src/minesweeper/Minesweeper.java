package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
	private static final int Rows = 7;
	private static final int Columns = 7;

	private static char[][] playerBoard = new char[Rows][Columns];

	private static char[][] fullBoard = new char[Rows][Columns];

	private static int numberOfMines = 10;

	/**
	 * Method that prints the board with the row and column index
	 */
	public static void printBoard() {
		char row = 'A';
		for (int i = 1; i <= Columns; i++) {
			System.out.print("\t" + i);
		}
		System.out.println("");
		for (int i = 0; i < Rows; i++) {
			System.out.print(row + "\t");
			for (int j = 0; j < Columns; j++) {
				System.out.print(playerBoard[i][j] + "\t");
			}
			System.out.println("");
			row++;
		}

	}
	
	/**
	 * Methot that put the 
	 */
	public static void putMines() {
		for (int i = 0; i < fullBoard.length; i++) {
			Arrays.fill(fullBoard[i], ' ');
		}
		for (int i = 0; i < playerBoard.length; i++) {
			Arrays.fill(playerBoard[i], ' ');
		}
		Random rand = new Random();
		int X;
		int Y;
		int cont = 0;
		while (cont < numberOfMines) {
			X = rand.nextInt(0, Columns);
			Y = rand.nextInt(0, Rows);
			if (fullBoard[X][Y] != 'M') {
				fullBoard[X][Y] = 'M';
				cont++;
			}
		}
	}
	
	public static boolean lookForMine(int x, int y) {
		boolean res = false;
		char minesCounter = '0';

		if (fullBoard[y][x] != 'M') {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					// If it goes out of range or its 0, it goes to the next iteration
					if (x + j <= -1 || x + j >= Columns || y + i <= -1 || y + i >= Rows || (i == 0 && j == 0)) {
						continue;
					} else {
						if (fullBoard[y + i][x + j] == 'M') {
							minesCounter++;
						}
					}
				}

			}
			playerBoard[y][x] = minesCounter;
			if (minesCounter == '0') {
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						if (x + j <= -1 || x + j >= Columns || y + i <= -1 || y + i >= Rows || (i == 0 && j == 0)) {
							continue;
						} else {
							if (fullBoard[y + i][x + j] != 'M' && playerBoard[y + i][x + j] == ' ') {
									lookForMine(x + j, y + i);
							}
						}

					}
				}
			}

		} else {
			playerBoard[y][x] = 'M';
			res = true;
		}
		return res;
	}
	
	public static boolean winner() {
		boolean res = false;
		int cont = 0;
		for (int i = 0 ; i < Rows ; i++) {
			for (int j = 0 ; i < Columns ; i++) {
				if(playerBoard[i][j] == ' ') {
					cont++;
				}
			}
		}
		if (cont == numberOfMines) {
			res = true;
		}
		return res;
	}
	
}
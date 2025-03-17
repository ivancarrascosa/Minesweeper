package minesweeper;

import java.util.Random;

public class Minesweeper {
	static final int N = 7;
	static final int M = 7;

	static char[][] playerBoard = new char[N][M];

	static char[][] fullBoard = new char[N][M];

	static int numberOfMines = 10;

	public static void printBoard() {
		char column = 'A';
		for (int i = 1; i <= M; i++) {
			System.out.print("\t" + i);
		}
		System.out.println("");
		for (int i = 0; i < N; i++) {
			System.out.print(column + "\t");
			for (int j = 0; j < M; j++) {
				System.out.print(playerBoard[i][j] + "\t");
			}
			System.out.println("");
			column++;
		}

	}
	
	public static void putMines() {
		Random rand = new Random();
		int X;
		int Y;
		int cont = 0;
		while (cont < numberOfMines) {
			X = rand.nextInt(0, M);
			Y = rand.nextInt(0,N);
			if (fullBoard[X][Y] != 'M') {
				fullBoard[X][Y] = 'M';
				cont++;
			}
		}
	}
	
	public static boolean userSelection(int x, int y) {
		boolean res = false;
		int minesCounter = 0;
		
		if (fullBoard[x][y] != 'M') {
			if(x == 0 && y == 0) {
				if(fullBoard[1][0] == 'M') {
					minesCounter += 1;
				} else {
					Minesweeper.userSelection(1, 0);
				}
			}
		} else {
			res = true;
		}
		return res;
	}

}
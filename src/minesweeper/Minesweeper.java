package minesweeper;

public class Minesweeper {
	static final int N = 7;
	static final int M = 7;
	
	char[][] playerBoard = new char[N][M];
	
	char[][] fullBoard = new char[N][M];
	
	int numberOfMines = 10;
	



	public static void printBoard() {
		for(int i = 1 ; i <= M ; i++) {
			System.out.print("\t" + i);
		}
	}
	
	

}
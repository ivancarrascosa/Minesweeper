package minesweeper;

public class Minesweeper {
	static final int N = 7;
	static final int M = 7;
	
	static char[][] playerBoard = new char[N][M];
	
	static char[][] fullBoard = new char[N][M];
	
	int numberOfMines = 10;
	
	


	public static void printBoard() {
		char column = 'A';
		for(int i = 1 ; i <= M ; i++) {
			System.out.print("\t" + i);
		}
		for (int i = 0 ; i < N ; i++) {
			System.out.print(column + "\t");
			for (int j = 0 ; j < M ; j++) {
				System.out.print(playerBoard[i][j] + "\t");
			}
			System.out.println("");
		}
		
		
	}
	
	

}
package minesweeper;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

public class MinesweeperMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean boom = false;
		Minesweeper.printBoard();
		Minesweeper.putMines();
		Minesweeper.printBoard();
		Minesweeper.lookForMine(0, 0);
		Minesweeper.printBoard();
		while (boom) {

			Minesweeper.printBoard();

		}

		sc.close();

	}

	public static char askCoordinateX() {
		char charX;

		System.out.println("Enter rows");
		charX = sc.nextLine().toUpperCase().charAt(0);

		return charX;
	}

	public static int askCoordinateY() {
		int y;

		System.out.println("Enter columnns");
		y = sc.nextInt();

		return y;
	}

}

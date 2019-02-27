package tictactoedab;

public class mainAI {
import java.awt.AWTException;
import java.util.Arrays;
import java.util.Scanner;

public class mainAI {
	static int turn = 0;
	static int pick = 2;
	static boolean gross = false;

	public static void main(String[] args) throws AWTException {

		String[][] board = { { " ", " ", " "}, { " ", " ", " "}, { " ", " ", " "} };
		/*
		 * AI myAI = new AI(); while(1==1) { printBoard(board); placePiece(board);
		 * printBoard(board); board = myAI.AIInput(board, 3); }
		 * 
		 */
		if (pick == 2) {
			AISmart2 myAI2 = new AISmart2();
			while (1 == 1) {
				printBoard(board);
				placePiece(board);
				printBoard(board);
				board = myAI2.AIInput(board, 3);
			}
		}
		AISmart myAI = new AISmart();
		if (pick == 1) {
			while (1 == 1) {
				printBoard(board);
				placePiece(board);
				printBoard(board);
				board = myAI.AIInput(board, 4);
			}
		}
	}

	public static void placePiece(String[][] board) {
		Scanner in = new Scanner(System.in);
		int stay = 1;
		while (stay == 1) {
			String coord = in.next();
			Scanner split = new Scanner(coord).useDelimiter(",");
			int row = split.nextInt();
			int column = split.nextInt();
			if (gross) {
				if (board[row - 1][column - 1].equals(" ") && row - 1 < board.length && column - 1 < board[0].length) {
					turn = 1;
					for (int i = 0; i < board.length; i++) {
						for (int j = 0; j < board[0].length; j++) {
							if (board[i][j].equals("X") || board[i][j].equals("O")) {
								turn++;
							}
						}
					}
					if (turn % 2 == 0) {
						board[row - 1][column - 1] = "O";
					} else {
						board[row - 1][column - 1] = "X";
					}
					stay = 0;
				} else {
					System.out.println("invalid input");
				}
			}
			if (!gross) {
				if(column < 0) {
					column *= -1;
				}
				if (board[column - 1][row - 1].equals(" ") && column - 1 < board.length && row - 1 < board[0].length) {
					turn = 1;
					for (int i = 0; i < board.length; i++) {
						for (int j = 0; j < board[0].length; j++) {
							if (board[i][j].equals("X") || board[i][j].equals("O")) {
								turn++;
							}
						}
					}
					if (turn % 2 == 0) {
						board[column - 1][row - 1] = "O";
					} else {
						board[column - 1][row - 1] = "X";
					}
					stay = 0;
				} else {
					System.out.println("invalid input");
				}
			}

		}
	}

	public static void printBoard(String[][] board) {
		for (int j = 0; j < board[0].length; j++) {
			System.out.print("+-");
		}
		System.out.println("+");
		for (int i = 0; i < board.length; i++) {
			String below = "";

			for (int j = 0; j < board[i].length; j++) {
				System.out.print("|" + board[i][j]);
				below += "+-";
			}

			System.out.println("|");
			System.out.println(below + "+");
		}

	}

}

}

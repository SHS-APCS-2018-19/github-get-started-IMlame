package unit7;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

public class tictactoeclient {
	public static final int winSize = 3;
	public String player1;
	static Scanner input = new Scanner(System.in);
	public String player2;
	static String[][] board = new String[3][3];
	public static boolean turn;
	public static ArrayList<Point> playerone = new ArrayList<Point>();
	public static ArrayList<Point> playertwo = new ArrayList<Point>();

	public static void main(String[] args) {


		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = " ";
			}
		}
		int end = 0;
		int r = 2;
		while (end == 0) {

			printBoard(board);
			handleinput(r);
			end = checkWin(board);

			r++;
		}

	}

	public static void handleinput(int runthru) {

		if (runthru % 2 == 0) {
			System.out.println("Player1's turn: Enter location");
			int que = input.nextInt() - 1;
			int you = input.nextInt() - 1;
			if (que > 3 || you > 3) {
				System.out.println("Numbers are out of range, pick again"); // this is if the inputted numbers are out of range
				que = input.nextInt() - 1;
				you = input.nextInt() - 1;
			}
			if (board[que][you] != " ") {
				System.out.println("Spot already selected, pick another spot"); // this is if the spot is already taken
				System.out.println("Player1's turn: Enter location");
				que = input.nextInt() - 1;
				you = input.nextInt() - 1;
			}
			Point points = new Point(que, you);
			playerone.add(points);
			board[que][you] = "X";
		}
		if (runthru % 2 == 1) {

			System.out.println("Player2's turn: Enter location");
			int que = input.nextInt() - 1;
			int you = input.nextInt() - 1;
			if (que > 3 || you > 3) {
				System.out.println("Numbers are out of range, pick again");
				que = input.nextInt() - 1;
				you = input.nextInt() - 1;
			}
			if (board[que][you] != " ") {
				System.out.println("Spot already selected, pick another spot");
				System.out.println("Player2's turn: Enter location");
				que = input.nextInt() - 1;
				you = input.nextInt() - 1;
			}
			Point points = new Point(que, you);
			playertwo.add(points);

			board[que][you] = "O";
		}
	}

	public static void printBoard(String[][] board) {
		String[][] arr = new String[3][3];
		System.out.println("+-+-+-+");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 2) {
					arr[i][j] = "|" + board[i][j] + "|";
					System.out.println(arr[i][j]);
					System.out.println("+-+-+-+");

				} else {
					arr[i][j] = "|" + board[i][j];
					System.out.print(arr[i][j]);
}
			}
		}
	
	}

	public static int checkWin(String[][] board) {
		int status = testWin(board);
		if (status == 1) {
			printBoard(board);
			System.out.println("X wins!");
			return 1;
		}
		if (status == 2) {
			printBoard(board);
			System.out.println("O wins!");
			return 2;
		}
		if (status == 3) {
			printBoard(board);
			System.out.println("Tie game!");
			return 3;
		}
		if (status == 0) {
			// (not necessary)
			System.out.println("Game continues!");
			return 0;
		}
		return 0;
	}

	public static int testWin(String[][] board) {
		// tests for row win

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - winSize + 1; j++) {
				String tester = "";
				for (int k = 0; k < winSize; k++) {
					tester += board[i][j + k];
				}
				int result = checkX(tester) + checkO(tester);
				if (result > 0) {
					return result;
				}

			}
		}

		// tests for column win

		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length - winSize + 1; j++) {
				String tester = "";
				for (int k = 0; k < winSize; k++) {
					tester += board[j + k][i];
				}
				int result = checkX(tester) + checkO(tester);
				if (result > 0) {
					return result;
				}
				// returns value if either X or O wins
			}
		}

		// tests for reverse diagonal win
		for (int i = 0; i < board.length - winSize + 1; i++) {
			for (int j = 0; j < board[i].length - winSize + 1; j++) {
				String tester = "";
				for (int k = 0; k < winSize; k++) {
					tester += board[i + k][j + k];
					// returns value if either X or O wins
				}
				int result = checkX(tester) + checkO(tester);
				if (result > 0) {
					return result;
				}
			}
		}

		// tests for diagonal win
		for (int i = board.length - 1; i >= winSize - 1; i--) {
			for (int j = 0; j < board[i].length - winSize + 1; j++) {
				String tester = "";
				for (int k = 0; k < winSize; k++) {
					tester += board[i - k][j + k];
					// returns value if either X or O wins
				}
				int result = checkX(tester) + checkO(tester);
				if (result > 0) {
					return result;
				}

			}
		}

		// tests for tie
		if (tieCheck(board)) {
			return 3;
		}
		return 0;

	}

	public static int checkX(String test) {
		for (int i = 0; i < test.length(); i++) {
			if ('X' != (test.charAt(i))) {
				return 0;
			}
		}
		return 1;
	}

	public static int checkO(String test) {
		for (int i = 0; i < test.length(); i++) {
			if ('O' != (test.charAt(i))) {
				return 0;
			}
		}
		return 2;
	}

	public static boolean tieCheck(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (!board[i][j].equals("X") && !board[i][j].equals("O")) {
					// if a space on the board doesn't equal X or O then the board isn't a tie
					return false;
				}
			}
		}
		// if every space on the board is an X or O then the board is a tie
		return true;
	}

}

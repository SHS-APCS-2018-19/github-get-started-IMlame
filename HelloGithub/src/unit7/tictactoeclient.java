package unit7;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

	public class tictactoeclient {
	public static final int winSize = 3;
	public String player1;

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
		//print out initial board
		int end = 0;
		int r = 2;
		while (end == 0) {

			printBoard(board);
			handleinput(r);
			end = checkWin(board);
			//end set to value of either 1(x wins) 2(o wins) 3(tie) or 0 (game continues)
			r++;
			//track the turn
		}

	}

	public static void handleinput(int runthru) {
		Scanner inputT = new Scanner(System.in);
		if (runthru % 2 == 0) {
			System.out.println("Player1's turn: Enter location");
			String inputTemp = inputT.nextLine();
			Scanner input = new Scanner(inputTemp).useDelimiter(",");
			//Takes in String, uses String in second scanner with using "," as a delimiter
			int que = input.nextInt() - 1;
			int you = input.nextInt() - 1;
			//set column and row to each input, -1 to match index
			if (que > 3 || you > 3) {
				System.out.println("Numbers are out of range, pick again"); // this is if the inputted numbers are out of range
				que = input.nextInt() - 1;
				you = input.nextInt() - 1;
			}
			if (board[que][you] != " ") {
				System.out.println("Spot already selected, pick another spot"); // this is if the spot is already taken
				System.out.println("Player1's turn: Enter location");
				String inputTemp2 = inputT.nextLine();
				Scanner input2 = new Scanner(inputTemp2).useDelimiter(",");
				//take in input again
				que = input2.nextInt() - 1;
				you = input2.nextInt() - 1;
			}
			Point points = new Point(que, you);
			playerone.add(points);
			board[que][you] = "X";
			//set board
		}
		if (runthru % 2 == 1) {
			System.out.println("Player2's turn: Enter location");
			String inputTemp = inputT.nextLine();
			Scanner input = new Scanner(inputTemp).useDelimiter(",");
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
				String inputTemp2 = inputT.nextLine();
				Scanner input2 = new Scanner(inputTemp2).useDelimiter(",");
				que = input2.nextInt() - 1;
				you = input2.nextInt() - 1;
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
		//translate number result to x win, o win, tie game, or game continuing
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
					//collects every character on board in row pattern

				}
				int result = checkX(tester) + checkO(tester);
				if (result > 0) {
					return result;
					//if tie, X wins, or O wins, return the result
				}

			}
		}

		// tests for column win

		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length - winSize + 1; j++) {
				String tester = "";
				for (int k = 0; k < winSize; k++) {
					tester += board[j + k][i];
					//collects every character on board in column pattern

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
					//collects every character on board in diagonal pattern
				}
				int result = checkX(tester) + checkO(tester);
				if (result > 0) {
					return result;
					//if tie, X wins, or O wins, return the result
				}
			}
		}

		// tests for diagonal win
		for (int i = board.length - 1; i >= winSize - 1; i--) {
			for (int j = 0; j < board[i].length - winSize + 1; j++) {
				String tester = "";
				for (int k = 0; k < winSize; k++) {
					tester += board[i - k][j + k];
					//collects every character on board in diagonal pattern

				}
				int result = checkX(tester) + checkO(tester);
				// returns value if either X or O wins
				if (result > 0) {
					return result;
					//if tie, X wins, or O wins, return the result
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
				//if every character isn't an "X" then return 0 (game continues)
			}
		}
		return 1;
		//X wins!
	}

	public static int checkO(String test) {
		for (int i = 0; i < test.length(); i++) {
			if ('O' != (test.charAt(i))) {
				return 0;
				//if every character isn't an "O" then return 0 (game continues)
			}
		}
		return 2;
		//O wins
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

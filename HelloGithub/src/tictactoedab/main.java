import java.util.Arrays;
import java.util.Scanner;

public class main {
	static int winSize = 5;
	static int turn = 0;

	public static void main(String[] args) {

		// example board
		System.out.println("Size of board?");
		Scanner in = new Scanner(System.in);
		String size = in.nextLine();
		Scanner sizeSplit = new Scanner(size).useDelimiter("x");
		String[][] board = new String[sizeSplit.nextInt()][sizeSplit.nextInt()];
		System.out.println("Size set to " + board.length + " x " + board[0].length);
		
		System.out.println("Win length?");
		winSize = in.nextInt();
		System.out.println("Win length set to " + winSize);
		//String[][] board = { { "X", "O", "X", "O" }, { "O", "X", "X", " " }, { "X", "O", "X", "X" }, { "X", "O", "O", "X" }, { "X", "O", "O", "X" } };
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = " ";
			}
		}

		int end = 0;
		
		while (end == 0) {
			printBoard(board);
			placePiece(board);
			end = checkWin(board);
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
			if (board[row - 1][column - 1].equals(" ") && row-1 < board.length && column-1 < board[0].length) {
				if (turn % 2 == 0) {
					board[row - 1][column - 1] = "X";
				} else {
					board[row - 1][column - 1] = "O";
				}
				turn++;
				stay=0;
			} else {
				System.out.println("invalid input");
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

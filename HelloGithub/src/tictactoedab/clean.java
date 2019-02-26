import java.util.Arrays;

public class clean {
	public static final int winSize = 3;
	public static void main(String[] args) {
		String[][] board = new String[3][3];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = " ";
			}
		}
		int end = 0;
		while(end == 0) {
			printBoard(board);
			end = checkWin(board);
		}
	}
	public static void printBoard(String[][] board) {
		String[][] arr = new String[3][3];
		System.out.println("+-+-+-+");
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(j == 2) {
					arr[i][j] = "|" + board[i][j] + "|";
					System.out.println(arr[i][j]);
				}
				else {
					arr[i][j] = "|" + board[i][j];
					System.out.print(arr[i][j]);
				}
			}
		}
		System.out.println("+-+-+-+");
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

import java.util.Arrays;
import java.util.Random;

public class AI {
	private static int winSize;

	public String[][] AIInput(String[][] board, int winSize) {
		boolean isX;
		this.winSize = winSize;
		int turn = 0;
		double[][] probability = new double[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].equals("X") || board[i][j].equals("O")) {
					turn++;
				}
			}
		}
		if (turn % 2 == 0) {
			isX = true;

		} else {
			isX = false;
		}
		probability = randomCalculate(board, probability, isX);
		double min = probability[0][0];
		int bigRow = 0;
		int bigColumn = 0;
		for(int i = 0; i < probability.length; i++) {
			for(int j = 0; j < probability[0].length; j++) {
				if(min < probability[i][j]) {
					min = probability[i][j];
					bigRow = i;
					bigColumn = j;
				}
			}
		}
		
		if(isX) {
			board[bigRow][bigColumn] = "X";
		} else {
			board[bigRow][bigColumn] = "O";
		}
		return board;
	}

	public double[][] randomCalculate(String[][] board, double[][] probability, boolean isX) {
		Random rand = new Random();
		double foundResult = 0;
		int score = 0;
		int row = 0;
		int column = 0;
		int initialRow;
		int initialColumn;
		boolean needInitial = false;
		String placer;
		if (isX) {
			placer = "X";
		} else {
			placer = "O";
		}
		String[][] test = new String[board.length][board[0].length];

		for (int i = 0; i < 500000; i++) {
			for(int k = 0; k < board.length; k++) {
				for(int j = 0; j < board[k].length; j++) {
					test[k][j] = board[k][j];
				}
			}

			needInitial = true;
			foundResult = 0;
			while (foundResult == 0) {
				row = rand.nextInt(board.length);
				column = rand.nextInt(board[0].length);
				if (test[row][column].equals(" ")) {
					test[row][column] = placer;
					if (needInitial) {
						initialRow = row;
						initialColumn = column;
					}
					if (placer.equals("X")) {
						placer = "O";
					} else {
						placer = "X";
					}
					foundResult = checkWin(test, isX);
				}
			}
			if (probability[row][column] != 0) {
				probability[row][column] += foundResult;
				probability[row][column] /= 2;
			} else {
				probability[row][column] += foundResult;
			}
		}

		for(int i = 0; i < board.length; i++) {
			for(int k = 0; k < board[0].length; k++) {
				if(board[i][k].equals("X") || board[i][k].equals("O")) {
					probability[i][k] = -10;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(probability[i]));
		}
		return probability;
	}

	public int checkWin(String[][] board, boolean isX) {
		int status = testWin(board);
		if (status == 1) {
			if (isX) {
				return 5;
			} else {
				return -9;
			}
		}
		if (status == 2) {
			if (isX) {
				return -9;
			} else {
				return 5;
			}
		}
		if (status == 3) {
			return -1;
		}
		return 0;
	}

	public int testWin(String[][] board) {
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

	public int checkX(String test) {
		for (int i = 0; i < test.length(); i++) {
			if ('X' != (test.charAt(i))) {
				return 0;
			}
		}
		return 1;
	}

	public int checkO(String test) {
		for (int i = 0; i < test.length(); i++) {
			if ('O' != (test.charAt(i))) {
				return 0;
			}
		}
		return 2;
	}

	public boolean tieCheck(String[][] board) {
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

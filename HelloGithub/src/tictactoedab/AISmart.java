import java.awt.AWTException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AISmart2 {
	static int total = 0;
	private static int winSize;
	static boolean debug = false;
	static boolean boardPrintOut = false;

	public String[][] AIInput(String[][] board, int winSize) {
		boolean isX = testTurn(board);
		this.winSize = winSize;
		double[][] probability = new double[board.length][board[0].length];
		probability = deepCalculate(board, probability, winSize, isX);

		// test for immediate loss
		for (int e = 0; e < board.length; e++) {
			for (int f = 0; f < board[e].length; f++) {
				if (board[e][f].equals(" ")) {
					board[e][f] = opXO(isX);
//					System.out.println(testWin(board) + " = 2? and " + isX + "\t" + testWin(board) + " = 1? and " + !isX);
//					System.out.println(Arrays.deepToString(board));

					if ((testWin(board) == 2 && isX) || (testWin(board) == 1 && !isX)) {
						board[e][f] = " ";
						probability[e][f] = 99;
					}
					board[e][f] = " ";
				}

			}
		}
		for (int i = 0; i < probability.length; i++) {
			System.out.println(Arrays.toString(probability[i]));
		}
		double min = probability[0][0];
		int bigRow = 0;
		int bigColumn = 0;
		for (int i = 0; i < probability.length; i++) {
			for (int j = 0; j < probability[i].length; j++) {
				if (min < probability[i][j]) {
					min = probability[i][j];
				}
			}
		}
		int numSame = 0;
		for (int i = 0; i < probability.length; i++) {
			for (int j = 0; j < probability[i].length; j++) {
				if (min == probability[i][j]) {
					numSame++;
				}
			}
		}
		Random rand = new Random();
		int ranChosen = rand.nextInt(numSame) + 1;
		int progress = 0;
		for (int i = 0; i < probability.length; i++) {
			for (int j = 0; j < probability[i].length; j++) {
				if (min == probability[i][j]) {
					progress++;
					if (progress == ranChosen) {
						if (isX) {
							board[i][j] = "X";
						} else {
							board[i][j] = "O";
						}
					}
				}
			}
		}

		return board;

	}

	public double[][] deepCalculate(String[][] board, double[][] probability, int winSize, boolean isX) {
		ArrayList<uqAr> list = new ArrayList<uqAr>();
		String[][] currentStep = new String[board.length][board[0].length];
		// copy initial board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				currentStep[i][j] = board[i][j];
			}
		}
		// copy initial board into list array
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board[0].length; b++) {
				double scoreTotal = 0;
				double numsCalculated = 0;
				double methodScore = 0;
				if (board[a][b].equals(" ")) {
					// test for valid spot
					probability[a][b] = calcX(currentStep, isX, board, a, b);

				} else {
					// invalid spot
					probability[a][b] = -100;
				}
			}
		}

		return probability;

	}

	public double calcX(String[][] currentStep, boolean isX, String[][] board, int a, int b) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		// test for immediate loss

		currentStep[a][b] = XO(isX);
		// test for immediate win
		if ((testWin(currentStep) == 1 && isX) || (testWin(currentStep) == 2 && !isX)) {
			currentStep[a][b] = " ";
			return 100;
		}
		scoreTotal = checkWin(currentStep, isX, testWin(currentStep));
		methodScore = calcO(currentStep, isX, board);
		currentStep[a][b] = " ";
		if (methodScore != -100 && methodScore != 0) {
			return (scoreTotal + methodScore) / 2;
		}

		return scoreTotal;
	}

	public double calcO(String[][] currentStep, boolean isX, String[][] board) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(currentStep, isX, testWin(currentStep)) != 5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board[e].length; f++) {
					if (currentStep[e][f].equals(" ")) {
						currentStep[e][f] = opXO(isX);
						// test for immediate loss

						if (testWin(board) != 0) {
							return checkWin(currentStep, isX, testWin(currentStep));
						}
						methodScore = calcX2(currentStep, isX, board);
						scoreTotal += checkWin(currentStep, isX, testWin(currentStep));
						numsCalculated++;
						currentStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {

			return 5;
		}
		return scoreTotal / numsCalculated;
	}

	public double calcX2(String[][] currentStep, boolean isX, String[][] board) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(currentStep, isX, testWin(currentStep)) != -5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board[e].length; f++) {
					if (currentStep[e][f].equals(" ")) {
						currentStep[e][f] = XO(isX);
						if (testWin(board) != 0) {
							return checkWin(currentStep, isX, testWin(currentStep));
						}
						methodScore = calcO2(currentStep, isX, board);
						scoreTotal += checkWin(currentStep, isX, testWin(currentStep));
						numsCalculated++;
						currentStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {

			return -5;
		}
		return scoreTotal / numsCalculated;

	}

	public double calcO2(String[][] currentStep, boolean isX, String[][] board) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(currentStep, isX, testWin(currentStep)) != 5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board[e].length; f++) {
					if (currentStep[e][f].equals(" ")) {
						currentStep[e][f] = opXO(isX);
						if (testWin(board) != 0) {
							return checkWin(currentStep, isX, testWin(currentStep));
						}
						scoreTotal += checkWin(currentStep, isX, testWin(currentStep));
						numsCalculated++;
						methodScore = calcX3(currentStep, isX, board);
						currentStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {

			return 5;
		}
		return scoreTotal / numsCalculated;
	}

	public double calcX3(String[][] currentStep, boolean isX, String[][] board) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(currentStep, isX, testWin(currentStep)) != -5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board[e].length; f++) {
					if (currentStep[e][f].equals(" ")) {
						currentStep[e][f] = XO(isX);
						if (testWin(board) != 0) {
							return checkWin(currentStep, isX, testWin(currentStep));
						}
						scoreTotal += checkWin(currentStep, isX, testWin(currentStep));
						numsCalculated++;
						methodScore = calcO3(currentStep, isX, board);
						currentStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {
			return -5;
		}
		return scoreTotal / numsCalculated;

	}

	public double calcO3(String[][] currentStep, boolean isX, String[][] board) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(currentStep, isX, testWin(currentStep)) != 5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board[e].length; f++) {
					if (currentStep[e][f].equals(" ")) {
						currentStep[e][f] = opXO(isX);
						if (testWin(board) != 0) {
							return checkWin(currentStep, isX, testWin(currentStep));
						}
						scoreTotal += checkWin(currentStep, isX, testWin(currentStep));
						numsCalculated++;
						if (board.length <= 3) {
							methodScore = calcX4(currentStep, isX, board);
						}
						currentStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {
			return 5;
		}
		return scoreTotal / numsCalculated;
	}

	public double calcX4(String[][] currentStep, boolean isX, String[][] board) {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(currentStep, isX, testWin(currentStep)) != -5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board[e].length; f++) {
					if (currentStep[e][f].equals(" ")) {
						currentStep[e][f] = XO(isX);
						total++;
						System.out.println(total);
						if (testWin(board) != 0) {
							return checkWin(currentStep, isX, testWin(currentStep));
						}
						scoreTotal += checkWin(currentStep, isX, testWin(currentStep));
						numsCalculated++;
						currentStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return scoreTotal / numsCalculated + methodScore / 2;
			}

		} else {
			return -5;
		}
		return scoreTotal / numsCalculated;

	}

	public String XO(boolean isX) {
		if (isX) {
			return "X";
		} else {
			return "O";
		}
	}

	public String opXO(boolean isX) {
		if (isX) {
			return "O";
		} else {
			return "X";
		}
	}

	public boolean testTurn(String[][] board) {
		boolean isX;
		int turn = 0;
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
		return isX;
	}

	public String[][] nextStep(String[][] currentStep) {
		String[][] nextStep = currentStep.clone();
		return nextStep;
	}

	public int checkWin(String[][] board, boolean isX, int status) {
		if (boardPrintOut) {
			for (int i = 0; i < board.length; i++) {
				System.out.println(Arrays.toString(board[i]));
			}
			System.out.println();

		}
		if (status == 1) {
			if (isX) {
				if (debug) {
					System.out.println("win");
				}
				return 5;
			} else {
				if (debug) {
					System.out.println("lose");
				}
				return -10;
			}
		}
		if (status == 2) {
			if (isX) {
				if (debug) {
					System.out.println("lose");
				}
				return -10;
			} else {
				if (debug) {
					System.out.println("win");
				}
				return 5;
			}
		}
		if (status == 3) {
			if (debug) {
				System.out.println("tie");
			}
			return 0;
		}
		if (debug) {
			System.out.println("nothing");
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

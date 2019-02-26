import java.awt.AWTException;
import java.awt.Robot;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AISmart {
	private static int winSize;
	static boolean debug = false;
	static boolean boardPrintOut = false;
	static int total = 0;
	public String[][] AIInput(String[][] board, int winSize) throws AWTException {
		boolean isX = testTurn(board);
		this.winSize = winSize;
		double[][] probability = new double[board.length][board[0].length];
		probability = deepCalculate(board, probability, winSize, isX);
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
		for(int i = 0; i < probability.length; i++) {
			for(int j = 0; j < probability[i].length; j++) {
				if(min == probability[i][j]) {
					numSame++;
				}
			}
		}
		System.out.println(numSame);
		Random rand = new Random();
		int ranChosen = rand.nextInt(numSame) +1;
		System.out.println(ranChosen);
		int progress = 0;
		for(int i = 0; i < probability.length; i++) {
			for(int j = 0; j < probability[i].length; j++) {
				if(min == probability[i][j]) {
					progress++;
					if(progress == ranChosen) {
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

	public double[][] deepCalculate(String[][] board, double[][] probability, int winSize, boolean isX) throws AWTException {
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
					list.add(0, uqAr.make(currentStep));
					probability[a][b] = calcX(list, isX, board, a, b);
				} else {
					// invalid spot
					probability[a][b] = -100;
				}
			}
		}
		for (int i = 0; i < probability.length; i++) {
			System.out.println(Arrays.toString(probability[i]));
		}
		System.out.println(total);
		return probability;

	}

	public double calcX(ArrayList<uqAr> list, boolean isX, String[][] board, int a, int b) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		list.get(0).nextStep[a][b] = XO(isX);
		scoreTotal = checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
		methodScore = calcO(list, isX, list.get(0).nextStep);
		list.get(0).nextStep[a][b] = " ";
		if (methodScore != -100 && methodScore != 0) {
			return (scoreTotal + methodScore)/2;
		}
		return scoreTotal;
	}

	public double calcO(ArrayList<uqAr> list, boolean isX, String[][] board) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		System.out.println(checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)));
		if (checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)) != 5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board.length; f++) {
					if (list.get(0).nextStep[e][f].equals(" ")) {
						list.get(0).nextStep[e][f] = opXO(isX);
						if (testWin(board) != 0) {
							return checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						}
						methodScore = calcX2(list, isX, board);
						scoreTotal += checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						numsCalculated++;
						list.get(0).nextStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {
			System.out.println("skip");
			return 5;
		}
		return scoreTotal / numsCalculated;
	}
	
	public double calcX2(ArrayList<uqAr> list, boolean isX, String[][] board) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)) != -5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board.length; f++) {
					if (list.get(0).nextStep[e][f].equals(" ")) {
						list.get(0).nextStep[e][f] = XO(isX);
						if (testWin(board) != 0) {
							return checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						}
						methodScore = calcO2(list, isX, board);
						scoreTotal += checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						numsCalculated++;
						list.get(0).nextStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {
			System.out.println("skip");
			return -5;
		}
		return scoreTotal / numsCalculated;

	}

	public double calcO2(ArrayList<uqAr> list, boolean isX, String[][] board) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)) != 5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board.length; f++) {
					if (list.get(0).nextStep[e][f].equals(" ")) {
						list.get(0).nextStep[e][f] = opXO(isX);
						if (testWin(board) != 0) {
							return checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						}
						scoreTotal += checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						numsCalculated++;
						methodScore = calcX3(list, isX, board);
						list.get(0).nextStep[e][f] = " ";
						// place O
					}
				}
			}
			if (methodScore > -90 && methodScore != 0) {
				return (scoreTotal / numsCalculated + methodScore) / 2;
			}

		} else {
			System.out.println("skip");
			return 5;
		}
		return scoreTotal / numsCalculated;
	}
	public double calcX3(ArrayList<uqAr> list, boolean isX, String[][] board) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)) != -5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board.length; f++) {
					if (list.get(0).nextStep[e][f].equals(" ")) {
						list.get(0).nextStep[e][f] = XO(isX);
						if (testWin(board) != 0) {
							return checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						}
						scoreTotal += checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						numsCalculated++;
						methodScore = calcO3(list, isX, board);
						list.get(0).nextStep[e][f] = " ";
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
	
	public double calcO3(ArrayList<uqAr> list, boolean isX, String[][] board) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)) != 5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board.length; f++) {
					if (list.get(0).nextStep[e][f].equals(" ")) {
						list.get(0).nextStep[e][f] = opXO(isX);
						if (testWin(board) != 0) {
							return checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						}
						scoreTotal += checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						numsCalculated++;
						methodScore = calcX4(list, isX, board);
						list.get(0).nextStep[e][f] = " ";
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
	
	public double calcX4(ArrayList<uqAr> list, boolean isX, String[][] board) throws AWTException {
		double scoreTotal = 0;
		double numsCalculated = 0;
		double methodScore = 0;
		if (checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep)) != -5) {
			for (int e = 0; e < board.length; e++) {
				for (int f = 0; f < board.length; f++) {
					if (list.get(0).nextStep[e][f].equals(" ")) {
						list.get(0).nextStep[e][f] = XO(isX);
						total++;
						if (testWin(board) != 0) {
							return checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						}
						scoreTotal += checkWin(list.get(0).nextStep, isX, testWin(list.get(0).nextStep));
						numsCalculated++;
						list.get(0).nextStep[e][f] = " ";
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

	public int checkWin(String[][] board, boolean isX, int status) throws AWTException {
		if (boardPrintOut) {
			for (int i = 0; i < board.length; i++) {
				System.out.println(Arrays.toString(board[i]));
			}
			System.out.println();
			Robot robot = new Robot();
			robot.delay(200);
			
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

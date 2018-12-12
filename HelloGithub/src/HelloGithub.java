import java.util.Arrays;
import java.util.Scanner;

public class JavaProject1 {

	//test cases:
	//1/2 + 54_3/3 = 55 1/2
	//3 + 4/3 * 53 + 3_5/20 = 76 11/12
	//5 * 3 + 54 - 54 + 4 / 6 = 15 2/3 
	//6_3/5 - 5 = 1 3/5
	//7 + 3/3 - 1 = 7
	//66/4 * 4/3 = 22
	//2/1 + 4 * 7 = 30
	//4 + 5 * 3 = 19
	//-1/2 * -3_4/5 negative
	//8/2 * -2 negative
	//3/2 + 4/5 simple fractions
	//1_2/3 * 4_5/6 mixed fractions
	//1 - 2 whole number
	
	public static void main(String[] args) {
		String userInput = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Hello, welcome to the Fraction Calculator!");
		while (!userInput.equals("quit")) {
			System.out.println("Enter an expression or (\"quit\"): ");
			userInput = in.nextLine();
			System.out.println();
			if (!userInput.equals("quit")) {
				String[] arrayInput = inputSplit(userInput);
				System.out.println("array got");
				if (test(arrayInput, userInput)) {
					int[][] fractions = intoNumeDenom(arrayInput);
					String[] operators = getOperators(arrayInput);
					int[][] multiAndDivide = mathOrder(fractions, operators);
					int[] mathDone = subtractAndAdd(multiAndDivide, operators);
					System.out.println(gcd(mathDone));
				}
			}
		}
		System.out.println("Goodbye!");
	}

	public static String gcd(int[] mathDone) {
		try {
			// catching /0
			int numerator = mathDone[0];
			int denominator = mathDone[1];
			int whole = numerator / denominator;
			// find whole number
			int remainder = numerator % denominator;
			// find remainder
			if (remainder == 0) {
				return "" + whole;
				// return whole number if no remainder
			}

			for (int i = denominator; i > 0; i--) {
				if (remainder % i == 0 && denominator % i == 0) {
					return "" + whole + " " + remainder / i + "/" + denominator / i;
					// find number that divides into both numerator and denominator
				}
			}
			return "" + whole + " " + remainder + "/" + denominator;
		} catch (ArithmeticException e) {
			System.out.println("Divided by 0");
			// print error statement
		}
		return "";
	}

	public static String[] inputSplit(String input) {
		int count = 0;
		int distribute = 0;
		Scanner test = new Scanner(input);
		while (test.hasNext()) {
			test.next();
			count++;
			// count input length
		}

		String[] arrayInput = new String[count];
		// create array with length of input

		Scanner intoArray = new Scanner(input);

		while (intoArray.hasNext()) {
			if (distribute < count) {
				arrayInput[distribute] = intoArray.next();
				// distribute each token into new array slot
				distribute++;
			}
		}
		return arrayInput;
	}

	public static int[][] intoNumeDenom(String[] arrayInput) {
		int whole = 1;
		int[][] fractions = new int[(arrayInput.length + 1) / 2][2];
		for (int i = 0; i < (arrayInput.length + 1) / 2; i++) {
			if (arrayInput[i * 2].indexOf('_') > -1) {
				// find whole number?
				whole = Integer.parseInt(arrayInput[i * 2].substring(0, arrayInput[i * 2].indexOf('_')));
				// sets whole number to "whole"
				System.out.println(whole);
				if (arrayInput[i * 2].indexOf('/') > -1) {
					// checks for divisor operator
					int num = (Integer.parseInt(arrayInput[i * 2].substring(arrayInput[i * 2].indexOf('_') + 1,
							arrayInput[i * 2].indexOf('/'))));
					if(whole < 0) {
						num *= -1;
					}
					
					fractions[i][0] = (whole * Integer.parseInt(arrayInput[i * 2]
							.substring(arrayInput[i * 2].indexOf('/') + 1, arrayInput[i * 2].length())))
							+ num;

					// add whole number*denominator to numerator

					fractions[i][1] = Integer.parseInt(arrayInput[i * 2].substring(arrayInput[i * 2].indexOf('/') + 1,
							arrayInput[i * 2].length()));
					// finds denominator (in between "/" and end)
				}
			}

			if (arrayInput[i * 2].indexOf('_') == -1) {
				// not find whole number?
				if (arrayInput[i * 2].indexOf('/') > -1) {
					fractions[i][0] = Integer.parseInt(arrayInput[i * 2].substring(0, arrayInput[i * 2].indexOf('/')));
					// set numerator
					fractions[i][1] = Integer.parseInt(arrayInput[i * 2].substring(arrayInput[i * 2].indexOf('/') + 1,
							arrayInput[i * 2].length()));
					// set denominator
				} else {
					fractions[i][0] = Integer.parseInt(arrayInput[i * 2]);
					fractions[i][1] = 1;
					// no denominator
				}
			}

		}
		System.out.println(Arrays.deepToString(fractions));
		return fractions;
	}

	public static String[] getOperators(String[] arrayInput) {
		String[] operators = new String[(arrayInput.length - 1) / 2];
		for (int i = 0; i < (arrayInput.length - 1) / 2; i++) {
			operators[i] = arrayInput[(i * 2) + 1];
			// operators are every even number in token #
		}
		System.out.println(Arrays.toString(operators));
		return operators;
	}

	public static int[][] mathOrder(int[][] fractions, String[] operators) {
		int numOfMultiplyDivide = 0;
		for (String n : operators) {
			if (n.equals("*") || n.equals("/")) {
				numOfMultiplyDivide++;
			}
		}
		int[][] multiAndDivide = new int[fractions.length - numOfMultiplyDivide][2];
		int mADPlaceHold = 0;
		for (int i = 0; i <= operators.length;) {
			if (i < operators.length && (operators[i].equals("*") || operators[i].equals("/"))) {
				while (i < operators.length && (operators[i].equals("*") || operators[i].equals("/"))) {
					if (i < operators.length && operators[i].equals("*")) {
						// find multiply, multiply across
						fractions[0][0] = fractions[i][0] * fractions[i + 1][0];
						fractions[0][1] = fractions[i][1] * fractions[i + 1][1];
						i++;
						System.out.println("multiplied");
						while (i < operators.length && (operators[i].equals("*") || operators[i].equals("/"))) {
							// check for "/" and "*" operators in a row
							if (i < operators.length && operators[i].equals("*")) {
								fractions[0][0] = fractions[0][0] * fractions[i + 1][0];
								fractions[0][1] = fractions[0][1] * fractions[i + 1][1];
								i++;
								System.out.println("dab");
							}

							if (i < operators.length && operators[i].equals("/")) {
								fractions[0][0] = fractions[0][0] * fractions[i + 1][1];
								fractions[0][1] = fractions[0][1] * fractions[i + 1][0];
								i++;
							}
						}
					}

					if (i < operators.length && operators[i].equals("/")) {
						// find divide, cross multiply
						fractions[0][0] = fractions[i][0] * fractions[i + 1][1];
						fractions[0][1] = fractions[i][1] * fractions[i + 1][0];
						i++;
						System.out.println("divided");
						while (i < operators.length && (operators[i].equals("*") || operators[i].equals("/"))) {
							// check for "/' and "*" operators in a row
							if (i < operators.length && operators[i].equals("*")) {
								fractions[0][0] = fractions[0][0] * fractions[i + 1][0];
								fractions[0][1] = fractions[0][1] * fractions[i + 1][1];
								i++;
							}

							if (i < operators.length && operators[i].equals("/")) {
								fractions[0][0] = fractions[0][0] * fractions[i + 1][1];
								fractions[0][1] = fractions[0][1] * fractions[i + 1][0];
								i++;
							}
						}
					}

					System.out.println("past multiplied");
				}
				System.out.println("called");
				// set to new array (all equations that aren't being divided or multiplied)
				multiAndDivide[mADPlaceHold][0] = fractions[0][0];
				multiAndDivide[mADPlaceHold][1] = fractions[0][1];
				mADPlaceHold++;
				i++;
				System.out.println(Arrays.deepToString(multiAndDivide) + " in a row!");

			} else {
				// check if at beginning of equation
				System.out.println(i);
				System.out.println(Arrays.deepToString(multiAndDivide));
				System.out.println(i - 1 + " >= 0 && " + (i) + " <= " + operators.length);
				if (i <= operators.length && i - 1 < 0) {
					multiAndDivide[mADPlaceHold][0] = fractions[i][0];
					multiAndDivide[mADPlaceHold][1] = fractions[i][1];
					System.out.println("small");
					// check if at end of equation

				} else if (i <= operators.length && i + 1 > operators.length) {
					multiAndDivide[mADPlaceHold][0] = fractions[i][0];
					multiAndDivide[mADPlaceHold][1] = fractions[i][1];
					System.out.println("big");

					// checks if inbetween -/+ and -/+
				} else if ((i - 1 >= 0 && i < operators.length) && (operators[i].equals("+") || operators[i].equals("-")
						&& (operators[i - 1].equals("+") || operators[i - 1].equals("-")))) {
					multiAndDivide[mADPlaceHold][0] = fractions[i][0];
					multiAndDivide[mADPlaceHold][1] = fractions[i][1];
					System.out.println("else");
				}
				mADPlaceHold++;
				i++;
				System.out.println("increased");

			}
		}
		System.out.println(Arrays.deepToString(multiAndDivide));
		return multiAndDivide;
	}

	public static int[] subtractAndAdd(int[][] multiAndDivide, String[] operators) {
		int factorPlacement = 1;
		for (String n : operators) {
			if (n.equals("+")) {
				if (multiAndDivide[factorPlacement][0] != 0) {
					// setting same denominators and stuff
					multiAndDivide[0][0] = multiAndDivide[0][0] * multiAndDivide[factorPlacement][1];
					multiAndDivide[factorPlacement][0] = multiAndDivide[0][1] * multiAndDivide[factorPlacement][0];
					multiAndDivide[0][1] = multiAndDivide[0][1] * multiAndDivide[factorPlacement][1];
					multiAndDivide[0][0] = multiAndDivide[0][0] + multiAndDivide[factorPlacement][0];
					factorPlacement++;
					System.out.println("dab");
					System.out.println(Arrays.deepToString(multiAndDivide));
				} else {
					factorPlacement++;
				}
			}
			if (n.equals("-")) {
				if (multiAndDivide[factorPlacement][0] != 0) {
					// setting same denominators and stuff
					multiAndDivide[0][0] = multiAndDivide[0][0] * multiAndDivide[factorPlacement][1];
					multiAndDivide[factorPlacement][0] = multiAndDivide[0][1] * multiAndDivide[factorPlacement][0];
					multiAndDivide[0][1] = multiAndDivide[0][1] * multiAndDivide[factorPlacement][1];
					multiAndDivide[0][0] = multiAndDivide[0][0] - multiAndDivide[factorPlacement][0];
					factorPlacement++;
				} else {
					factorPlacement++;
				}
			}
		}
		// FINAL FRACTION WOOOOOOOOOOOOOOOOOOOOOOOOO
		int[] mathDone = new int[2];
		mathDone[0] = multiAndDivide[0][0];
		mathDone[1] = multiAndDivide[0][1];
		System.out.println(Arrays.toString(mathDone));
		return mathDone;
	}

	public static boolean test(String[] arrayInput, String userInput) {
		// testing
		boolean accepted = false;
		char[] charactersAccepted = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '/', '*', '_', '.',
				' ' };
		String[] operatorsAccepted = { "+", "-", "/", "*" };
		char[] fractionAccepted = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_', '/','-' };
		for (String n : arrayInput) {
			for (int i = 0; i < n.length(); i++) {
				accepted = false;
				for (int a : charactersAccepted) {
					if (a == n.charAt(i)) {
						accepted = true;
					}
				}
				if (accepted == false) {
					System.out.println("invalid character input");
					return false;
				}
			}

		}

		if (arrayInput.length % 2 == 0) {
			System.out.println("missing statement");
			return false;
		}

		if (arrayInput.length == 1) {
			System.out.println("missing statement");
			return false;
		}

		for (int i = 1; i < arrayInput.length; i += 2) {
			accepted = false;
			for (String n : operatorsAccepted) {
				if (arrayInput[i].equals(n)) {
					accepted = true;
				}
			}
			if (accepted == false) {
				System.out.println("invalid operator");
				return false;
			}
		}

		for (int i = 0; i < arrayInput.length; i += 2) {
			for (int j = 0; j < arrayInput[i].length(); j++) {
				accepted = false;
				for (char n : fractionAccepted) {
					if (arrayInput[i].charAt(j) == n) {
						accepted = true;
					}
				}
				if (accepted == false) {
					System.out.println("invalid input fraction");
					return false;
				}
			}
		}

		for (int i = 0; i < arrayInput.length; i += 2) {
			int divideCount = 0;
			for (int j = 0; j < arrayInput[i].length(); j++) {
				if (arrayInput[i].charAt(j) == '/') {
					divideCount++;
					if (divideCount == 2) {
						System.out.println("multiple \"/\" placement");
						return false;
					}
					if (j - 1 >= 0 && j + 1 < arrayInput[i].length()) {
						if (arrayInput[i].charAt(j - 1) != '/' && arrayInput[i].charAt(j + 1) != '/') {
							if (arrayInput[i].charAt(j + 1) != '0') {
							} else {
								System.out.println("divide by 0");
								return false;
							}
						} else {
							System.out.println("invalid \"/\" placement");
							return false;
						}
					} else {
						System.out.println("invalid \"/\" placement");
						return false;
					}
				}
			}
		}

		return true;
	}
}

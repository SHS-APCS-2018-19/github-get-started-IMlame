import java.util.Scanner;

public class Range {
	private int max;
	private int min;

	public static Range parse(String input) {
		Scanner in = new Scanner(input).useDelimiter("-");
		Range newRange = new Range();
		newRange.min = in.nextInt();
		if (in.hasNextInt()) {
			newRange.max = in.nextInt();
		} else {
			newRange.max = newRange.min;
		}
		return newRange;
	}

	public boolean contains(int n) {
		if (n >= min && n <= max) {
			return true;
		} else {
//			System.out.println(n + " is not between the ranges of " + min + " and " + max);
			return false;
		}
	}

	public static boolean validRank(Scanner n) {
		int min = n.nextInt();
		int max = 0;
		if (n.hasNextInt()) {
			max = n.nextInt();
		} else {
			if (min >= 1 && min <= 743) {
			return true;
			} else {
				return false;
			}
		}
		//check for invalid rank
		if((min >= 0 && min <= 743) && (max >= 0 && max <= 743) && (max >= min)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validYear(Scanner n) {
		int min = n.nextInt();
		int max = 0;
		if (n.hasNextInt()) {
			max = n.nextInt();
		} else {
			if (min >= 1807 && min <= 2008) {
			return true;
			} else {
				return false;
			}
		}
		//check for invalid year
		if((min >= 1807 && min <= 2008) && (max >= 1807 && max <= 2008) && (max >= min)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}

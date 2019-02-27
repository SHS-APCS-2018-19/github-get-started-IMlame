package unit7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) throws FileNotFoundException {
		boolean Exercise4pt1 = false;
		Scanner names = new Scanner(new File("names.txt"));
		ArrayList<String> list = new ArrayList<>();
		while (names.hasNextLine()) {
			list.add(names.nextLine());
		}
		if (Exercise4pt1) {
			list.add("Sam");
		}

		System.out.println(list);

		String[] nameArray = new String[list.size()];
		nameArray = list.toArray(nameArray);
		if (Exercise4pt1) {
			insertionSort(nameArray);
			System.out.println(Arrays.toString(nameArray));
		} else {
			if (arrayValid(nameArray) && arrayValid2(nameArray) && sortedAlready(nameArray)) {
				insertionSort(nameArray);
				System.out.println(Arrays.toString(nameArray));
			}
		}
	}

	public static boolean arrayValid(String[] a) {
		if (a.length <= 1) {
			System.out.println("invalid number of names");
			return false;
		}
		return true;
	}

	public static boolean arrayValid2(String[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (!(a[i].compareTo(a[i + 1]) == 0)) {
				return true;
			}
		}
		System.out.println("every element the same");
		return false;
	}

	public static boolean sortedAlready(String[] a) {
		String[] smallToBig = a.clone();
		String[] bigToSmall = a.clone();
		insertionSort(smallToBig);
		for (int i = 0; i < smallToBig.length; i++) {
			bigToSmall[bigToSmall.length - i - 1] = smallToBig[i];
		}
		if (Arrays.equals(a, smallToBig)) {
			System.out.println("already sorted from small to big");
			return false;
		}
		if (Arrays.equals(a, bigToSmall)) {
			System.out.println("already sorted from big to small");
		}
		return true;

	}

	public static void insertionSort(String[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
				String temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
	}

}

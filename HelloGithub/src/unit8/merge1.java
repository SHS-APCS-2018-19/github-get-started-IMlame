package unit8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class merge1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner nums = new Scanner(new File("numbers.txt"));
		ArrayList<Integer> numsList = new ArrayList<>();
		while(nums.hasNext()) {
			nums.next();
			numsList.add(nums.nextInt());
		}
		int[] numsArr = new int[numsList.size()];
		for(int i = 0; i < numsList.size(); i++) {
			numsArr[i] = numsList.get(i);
		}
		mergeSortNums(numsArr);
		System.out.println(Arrays.toString(numsArr));
		
		Scanner strings = new Scanner(new File("names.txt"));
		ArrayList<String> stringsList = new ArrayList<>();
		while(strings.hasNextLine()) {
			stringsList.add(strings.nextLine());
		}
		String[] stringsArr = new String[stringsList.size()];
		for(int i = 0; i < stringsList.size(); i++) {
			stringsArr[i] = stringsList.get(i);
		}
		mergeSortStrings(stringsArr);
		System.out.println(Arrays.toString(stringsArr));
		
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("\"1\" for add number");
			System.out.println("\"2\" for add string");
			int input = in.nextInt();
			if(input == 1) {
				
				int[] temp = new int[numsArr.length+1];
				for(int i = 0; i < numsArr.length; i++) {
					temp[i] = numsArr[i];
				}
				temp[temp.length-1] = in.nextInt();
				numsArr = temp;
				mergeSortNums(numsArr);
				System.out.println(Arrays.toString(numsArr));
			}
			if(input == 2) {
				String[] temp = new String[stringsArr.length+1];
				for(int i = 0; i < stringsArr.length; i++) {
					temp[i] = stringsArr[i];
				}
				temp[temp.length-1] = in.next();
				stringsArr = temp;
				mergeSortStrings(stringsArr);
				System.out.println(Arrays.toString(stringsArr));
			}
		}
	}

	public static void mergeSortNums(int[] a) {
		if (a.length > 1) {
			int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
			
			mergeSortNums(left);
			mergeSortNums(right);

			mergeNums(a, left, right);
		}
	}
	
	public static void mergeNums(int[] result, int[] left, int[] right) {
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i < result.length; i++) {
			if(i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
				result[i] = left[i1];
				i1++;
			} else {
				result[i] = right[i2];
				i2++;
			}
		}
	}
	
	public static void mergeSortStrings(String[] a) {
		if (a.length > 1) {
			String[] left = Arrays.copyOfRange(a, 0, a.length / 2);
			String[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
			
			mergeSortStrings(left);
			mergeSortStrings(right);

			mergeStrings(a, left, right);
		}
	}
	
	public static void mergeStrings(String[] result, String[] left, String[] right) {
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i < result.length; i++) {
			if(i2 >= right.length || (i1 < left.length && left[i1].compareTo(right[i2]) <= 0)) {
				result[i] = left[i1];
				i1++;
			} else {
				result[i] = right[i2];
				i2++;
			}
		}
	}
}

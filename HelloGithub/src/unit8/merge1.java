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
		int count = 0;
		while(nums.hasNext()) {
			count++;
			nums.next();
			numsList.add(nums.nextInt());
			numsList.set);
		}
		int[] numsArr = new int[count];
		Scanner nums1 = new Scanner(new File("numbers.txt"));
		for(int i = 0; i < count; i++) {
			numsArr[i] = nums1.nextInt();
		}
		mergeSortNums(numsArr);
		System.out.println(Arrays.toString(numsArr));
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
}

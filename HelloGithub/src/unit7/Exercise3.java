package unit7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner nums = new Scanner(new File("names.txt"));
		int[] nameArray = new int[0];
		while(nums.hasNextInt()) {
			int[] nameTempArray = new int[nameArray.length+1];
			nameTempArray = nameArray.clone();
		}
		selectionSort(numList);
	}
		public static void selectionSort(int[] a) {
			for(int i = 0; i < a.length; i++) {
				int min = i;
				for(int j = i+1; j < a.length; j++) {
					if(a[j] < a[min]) {
						int temp = i;
						a[i] = a[min];
						a[min] = temp;
					}
				}
			}
		}
}

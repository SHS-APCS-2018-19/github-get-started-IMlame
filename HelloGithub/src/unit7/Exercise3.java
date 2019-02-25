
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner nums = new Scanner(new File("numbers.txt"));
		ArrayList<Integer> intList = new ArrayList<>();
		while(nums.hasNextInt()) {
			intList.add(nums.nextInt());
		}
		Integer[] intArray = new Integer[intList.size()];
		intArray = intList.toArray(intArray);
		selectionSort(intArray);
		
		
		Scanner names = new Scanner(new File("names.txt"));
		ArrayList<String> nameList = new ArrayList<>();
		while(names.hasNext()) {
			nameList.add(names.next());
		}
		String[] nameArray = new String[nameList.size()];
		nameArray = nameList.toArray(nameArray);
		selectionSortNamesAlpha(nameArray);
		
		while(true) {
			System.out.println("1 for sorted int list \n2 for sorted name list\n3 for reverse sorted name list");
			Scanner in = new Scanner(System.in);
			int input = in.nextInt();
			if(input == 1) {
				System.out.println(Arrays.toString(intArray));
			}
			if(input == 2) {
				selectionSortNamesAlpha(nameArray);
				System.out.println(Arrays.toString(nameArray));
			}
			if(input == 3) {
				selectionSortNamesRevAlpha(nameArray);
				System.out.println(Arrays.toString(nameArray));
			}
		}
	}
		public static void selectionSort(Integer[] a) {
			for(int i = 0; i < a.length; i++) {
				int min = i;
				for(int j = i+1; j < a.length; j++) {
					if(a[j] < a[min]) {
						min = j;
					}
				}
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
		
		public static void selectionSortNamesRevAlpha(String[] a) {
			for(int i = 0; i < a.length; i++) {
				int min = i;
				for(int j = i+1; j < a.length; j++) {
					if(a[j].compareTo(a[min]) > 0) {
						min = j;
					}
				}
				String temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
		public static void selectionSortNamesAlpha(String[] a) {
			for(int i = 0; i < a.length; i++) {
				int min = i;
				for(int j = i+1; j < a.length; j++) {
					if(a[j].compareTo(a[min]) < 0) {
						min = j;
					}
				}
				String temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}


}
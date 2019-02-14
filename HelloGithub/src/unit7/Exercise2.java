import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("numsearch.txt");
		Scanner nameCount = new Scanner(file);
		int counter = 0;
		while (nameCount.hasNext()) {
			counter++;
			nameCount.next();
		}
		int[] num = new int[counter];
		Scanner names = new Scanner(file);
		for (int i = 0; i < counter; i++) {
			num[i] = names.nextInt();
		}
		System.out.println(binarySearch(num, 5));
		System.out.println(binarySearch(num, 9));
		System.out.println(binarySearch(num, 43));
		System.out.println(binarySearch(num, 79));
		System.out.println(Arrays.binarySearch(num, 5));
		System.out.println(Arrays.binarySearch(num, 9));
		System.out.println(Arrays.binarySearch(num, 43));
		System.out.println(Arrays.binarySearch(num, 79));
	}

	public static int binarySearch(int[] num, int target) {
		int min = 0;
		int max = num.length - 1;
		int mid = 0;
		while (min <= max) {
			mid = (max+min)/2;
			if (num[mid] == target) {
				return mid;
			} else if (target < num[mid]) {
				max = mid - 1;
			} else if (target > num[mid]) {
				min = mid + 1;
			}
		}
		return mid * -1 - 1;

	}

}

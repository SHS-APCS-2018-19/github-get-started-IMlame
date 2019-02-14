package unit7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2Names {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] names = new String[20];
		Scanner fileName = new Scanner(new File("namesearch.txt"));
		int counter = 0;
		while (fileName.hasNextLine()) {
			names[counter] = fileName.nextLine();
			counter++;
		}
		System.out.println(Arrays.deepToString(names));
		System.out.println(binarySearch(names, "Dennis"));
		System.out.println(binarySearch(names, "Billy-Bob"));
		System.out.println(binarySearch(names, "Steve"));
		
	}

	public static int binarySearch(String[] names, String target) {
		int min = 0;
		int max = names.length - 1;
		int mid = 0;

		while (min < max) {
			mid = (min + max) / 2;
			if (target.compareTo(names[mid]) < 0) {
				max = mid - 1;
			} else if (target.compareTo(names[mid]) > 0) {
				min = mid + 1;
			} else if (target.compareTo(names[mid]) == 0) {
				return mid;
			}
		}
		return mid * -1 - 1;
	}

}

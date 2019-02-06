package unit7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercise1 {
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("SeqSearch.txt");
		int num7 = 0;
		int num9 = 0;
		int num45 = 0;
		Scanner in = new Scanner(file);
		while(in.hasNext()) {
			int next = in.nextInt();
			if(next == 7) {
				num7++;
			}
			if(next == 9) {
				num9++;
			}
			if(next == 45) {
				num45++;
			}
		}
		System.out.println("number of 7s: " + num7);
		System.out.println("number of 9s: " + num9);
		System.out.println("number of 45s: " + num45);
	}
}

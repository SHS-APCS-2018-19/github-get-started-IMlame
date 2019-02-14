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
		String all = "";
		while(in.hasNext()) {
			String next= in.next();
			if(next.equals("45")) {
				num45++;
			}
			all+=next;
		}
		for(int i = 0; i < all.length(); i++) {
			if(all.charAt(i) == '7') {
				num7++;
			}
			if(all.charAt(i) == '9') {
				num9++;
			}
		}
		
		System.out.println("number of 7s: " + num7);
		System.out.println("number of 9s: " + num9);
		System.out.println("number of 45s: " + num45);
	}
}

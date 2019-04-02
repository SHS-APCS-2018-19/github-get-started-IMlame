import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class test {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("GroceryList.txt"));
		int n = s.nextInt();
		String[] Suman = new String[n];
		for(int i = 0;i<n;i++) {
			Suman[i] = s.nextLine();
		}
		int b = s.nextInt();
		String[] Rajesh = new String[n];
		for(int j = 0;j<b;j++) {
			for(String k : Suman) {
				int t = 0;
				if(k.equals(Rajesh[j])) {
					System.out.println("Tomatoes for youza!");
					t++;
				}
				if(t==0) {
					System.out.println("No tomatoes for youza!");
				}
			}
		}
	}

}
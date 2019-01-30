package unit6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) throws IOException {
		File file = new File("employee.txt");
		Scanner scan = new Scanner(file);

		ArrayList<employee> list = new ArrayList<employee>();
		while(scan.hasNextLine()) {
			list.add(employee.createEmployee(scan.nextLine()));
		}
		System.out.println(list.get(2));
	}

}

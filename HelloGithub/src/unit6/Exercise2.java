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
		while (scan.hasNextLine()) {
			list.add(employee.createEmployee(scan.nextLine()));
		}
		employeeInfo(list);
		employeeSkills(list);
		employeeProjects(list);
	}

	public static void employeeInfo(ArrayList<employee> list) {
		for (employee n : list) {
			System.out.println("ID: " + n.getID() + " NAME: " + n.getName() + " BIRTHDAY: " + n.getBirthday());
		}
	}

	public static void employeeSkills(ArrayList<employee> list) {
		for (int i = 0; i < employee.uniqueSpecialty.size(); i++) {
			System.out.println();
			System.out.println(employee.uniqueSpecialty.get(i) + ": ");
			for (employee n : list) {
				if (n.Specialty.contains(employee.uniqueSpecialty.get(i))) {
					System.out.println(n.getName());
				}
			}
		}
	}

	public static void employeeProjects(ArrayList<employee> list) {
		for (int i = 0; i < employee.uniqueProject.size(); i++) {
			System.out.println();
			System.out.println(employee.uniqueProject.get(i) + ": ");
			for (employee n : list) {
				if (n.Projects.contains(employee.uniqueProject.get(i))) {
					System.out.println(n.getName());
				}
			}
		}
	}

}

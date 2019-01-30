package unit6;

import java.util.ArrayList;
import java.util.Scanner;

public class employee {
	String id;
	String name;
	String birthday;
	private static ArrayList<String> Specialty = new ArrayList<>();
	private static ArrayList<String> Projects = new ArrayList<>();
	public static employee createEmployee(String info) {
		Scanner three = new Scanner(info).useDelimiter(";");
		employee newEmployee = new employee();
		newEmployee.id = three.next();
		newEmployee.name = three.next();
		newEmployee.birthday = three.next();
		
		Scanner scanSpecialty = new Scanner(three.next());
		while (scanSpecialty.hasNext()) {
			Specialty.add(scanSpecialty.next());
		}
		
		Scanner scanProject = new Scanner(three.next());
		while (scanSpecialty.hasNext()) {
			Projects.add(scanProject.next());
		}
		return newEmployee;
	}
	public String toString() {
		return id + " " + name + " " + birthday + " " + Specialty;
	}
}

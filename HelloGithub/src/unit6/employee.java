package unit6;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class employee {
	private String id;
	private String name;
	private String birthday;
	public static ArrayList<String> uniqueSpecialty = new ArrayList<>();
	public static ArrayList<String> uniqueProject = new ArrayList<>();
	public ArrayList<String> Specialty = new ArrayList<>();
	public ArrayList<String> Projects = new ArrayList<>();
	public static employee createEmployee(String info) {
		Scanner three = new Scanner(info).useDelimiter(";");
		employee newEmployee = new employee();
		newEmployee.id = three.next();
		newEmployee.name = three.next();
		newEmployee.birthday = three.next();
		
		Scanner scanSpecialty = new Scanner(three.next()).useDelimiter(",");
		while (scanSpecialty.hasNext()) {
			String specialty = scanSpecialty.next();
			if(!uniqueSpecialty.contains(specialty)) {
				uniqueSpecialty.add(specialty);
			}
			newEmployee.Specialty.add(specialty);
		}
		
		Scanner scanProject = new Scanner(three.next()).useDelimiter(",");
		while (scanProject.hasNext()) {
			String project = scanProject.next();
			if(!uniqueProject.contains(project)) {
				uniqueProject.add(project);
			}
			newEmployee.Projects.add(project);
		}
		return newEmployee;
	}
	
 	public String toString() {
		return id + " " + name + " " + birthday + " " + Specialty + " " + Projects;
	}
 	
 	public String getID() {
 		return id;
 	}
 	public String getName() {
 		return name;
 	}
 	public String getBirthday() {
 		return birthday;
 	}
}

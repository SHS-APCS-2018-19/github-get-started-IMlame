import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClassMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		classes[] allClasses = null;
		ArrayList<classes> listAllClasses = new ArrayList<classes>();
		while (1 == 1) {
			System.out.println("\ntype \"1\" to add class \ntype \"2\" to add student\ntype \"3\" to get total number of courses\ntype \"4\" to find out more details about a course");
			int selectedNum = in.nextInt();
			if (selectedNum == 1) {
				listAllClasses.add(classes.createClass());
				allClasses = listAllClasses.toArray(new classes[listAllClasses.size()]);
				allClasses[allClasses.length-1].printClass(allClasses);
			}	
			if (selectedNum == 2) {
				int i = 0;
				System.out.println("What class?");
				Scanner nameOfClass = new Scanner(System.in);
				System.out.print("List of available classes: ");
				for(; i < allClasses.length-1; i++) {
					System.out.print((allClasses[i]).getClassName() + ", ");
				}
				//fencepost test
				System.out.println((allClasses[i]).getClassName());
				String className = nameOfClass.nextLine();
				int found = 0;
				for (int j = 0; j < allClasses.length; j++) {
					if (allClasses[j].getClassName().equals(className)) {
						allClasses[j].addStudent();
						found = 1;
					}
				}
				if(found == 0) {
					System.out.println("no class with that name found");
				}

			}
			if (selectedNum == 3) {
				System.out.println(classes.returnCourseNumber());
			}
			if (selectedNum == 4) {
				int i = 0;
				System.out.println("What class?");
				Scanner nameOfClass = new Scanner(System.in);
				System.out.print("List of available classes: ");
				for(; i < allClasses.length-1; i++) {
					System.out.print((allClasses[i]).getClassName() + ", ");
				}
				//fencepost test
				System.out.println((allClasses[i]).getClassName());
				String className = nameOfClass.nextLine();
				int found = 0;
				for (int j = 0; j < allClasses.length; j++) {
					if (allClasses[j].getClassName().equals(className)) {
						allClasses[j].printClass(allClasses);
						found = 1;
					}
				}
				if(found == 0) {
					System.out.println("no class with that name found");
				}
			}
		}
	}

}

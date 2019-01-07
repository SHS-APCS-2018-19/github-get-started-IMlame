import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class classes {
	private String className;
	private String teacherName;
	private int roomNumber;
	private int period;
	private String[] students;
	private static int courseNumber;
	private int currentCourseNumber;
	ArrayList<String> list = new ArrayList<String>();
	private final int MAX_CLASS_SIZE = 25;
	Scanner in = new Scanner(System.in);

	public static classes createClass() {
		classes newClass = new classes();
		System.out.println("class name?");
		newClass.addName();
		System.out.println("teacher name?");
		newClass.addTeacher();
		System.out.println("roomNumber?");
		newClass.addNumber();
		System.out.println("period?");
		newClass.addPeriod();
		courseNumber();
		newClass.currentCourseNumber = courseNumber;

		return newClass;
	}

	public static void courseNumber() {
		courseNumber++;
	}

	public static int returnCourseNumber() {
		return courseNumber;
	}

	public void addName() {
		className = in.nextLine();
	}

	public void addTeacher() {
		teacherName = in.nextLine();
	}

	public void addNumber() {
		roomNumber = in.nextInt();
	}

	public void addPeriod() {
		period = in.nextInt();
	}

	public void addStudent() {
		Scanner sAddStudents = new Scanner(System.in);
		System.out.println("name of student?");
		if (classHasRoom()) {
			list.add(sAddStudents.nextLine());
			students = list.toArray(new String[list.size()]);
			System.out.println(Arrays.toString(students));
		}
	}

	public String getClassName() {
		return className;
	}

	public void printClass(classes[] allClasses) {
		String returnStatement = "";
		String returnStatementPeriod = "";

		for (int i = 0; i < allClasses.length; i++)
			if (allClasses[i].teacherName.equals(teacherName)) {
				returnStatement += allClasses[i].className + " ";
			}

		returnStatement = "(teaches: " + returnStatement + ")";

		for (int i = 0; i < allClasses.length; i++)
			if (allClasses[i].period == period && !allClasses[i].className.equals(className)
					&& !allClasses[i].teacherName.equals(teacherName)) {
				returnStatementPeriod += " [" + allClasses[i].teacherName + ", " + allClasses[i].className + "] ";
			}
		if (!returnStatementPeriod.equals("")) {
			returnStatementPeriod = "(Conflicts with: " + returnStatementPeriod + ")";
		}
		System.out.printf(
				"Course #%d\nClass Name: %s \nTeacher Name: %s %s\nRoom Number: %d\nPeriod: %d %s\nStudents:"
						+ Arrays.toString(students) + "\n",
				currentCourseNumber, className, teacherName, returnStatement, roomNumber, period,
				returnStatementPeriod);
	}

	public boolean classHasRoom() {
		if(students == null) {
			return true;
		
		}else if (students != null && students.length < MAX_CLASS_SIZE) {
			return true;
		} else {
			System.out.println("class is full");
			return false;
		}
	}

}

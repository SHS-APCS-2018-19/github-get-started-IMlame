package src;

import java.util.Scanner;
public class birthday {
	private int month;
	private int day;
	private int year;
	Scanner in = new Scanner(System.in);
	
	public static birthday setBirthday() {
		birthday b1rthday = new birthday();
		System.out.println("Set birthday:");
		b1rthday.setMonth();
		b1rthday.setDay();
		b1rthday.setYear();
		return b1rthday;
	}
	
	public void setMonth() {
		System.out.println("Month?");
		month = in.nextInt();
	}
	
	public void setDay() {
		System.out.println("Day?");
		day = in.nextInt();
	}
	
	public void setYear() {
		System.out.println("Year?");
		year = in.nextInt();
	}
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}
}

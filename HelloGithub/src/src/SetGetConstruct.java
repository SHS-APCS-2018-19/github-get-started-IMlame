package src;


import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SetGetConstruct {
	private String Name;
	private String StreetAddress;
	private String CityNState;
	private birthday b1rthday;
	private static int record = 0;
	private int thisRecord = 0;
	static Scanner in = new Scanner(System.in);
		
	public static SetGetConstruct createInfo() {
	
		SetGetConstruct newInfo = new SetGetConstruct();
		System.out.println("Name?");
		newInfo.SetName(in.nextLine());
		
		System.out.println("Street Address?");
		newInfo.SetStreetAddress(in.nextLine());
		
		System.out.println("City and State?");
		newInfo.SetCityNState(in.nextLine());
		
		newInfo.SetBirthday();
		record++;
		newInfo.thisRecord = record;
		System.out.printf("#%d [%s]\nName: %s \nAddress = %s \nCity and State = %s \nBirthday = %s\n\n", newInfo.thisRecord, newInfo.getDateTime(), newInfo.Name, newInfo.StreetAddress, newInfo.CityNState, newInfo.b1rthday);
		return newInfo;
	}
	
	public void SetAllInfo() {		
		System.out.println("Name?");
		SetName(in.nextLine());
		
		System.out.println("Street Address?");
		SetStreetAddress(in.nextLine());
		
		System.out.println("City and State?");
		SetCityNState(in.nextLine());
	}
	
	public void SetBirthday() {
		b1rthday = birthday.setBirthday();
	}
	
	public void SetName(String Name) {
		this.Name = Name;
	}
	
	public void SetStreetAddress(String StreetAddress) {
		this.StreetAddress = StreetAddress;
	}
	
	public void SetCityNState(String CityNState) {
		this.CityNState = CityNState;
	}
	
	public void SetBirthday(birthday yay) {
		b1rthday = yay;
	}
	
	public String GetName() {
		return Name;
	}
	
	public String GetStreetAddress() {
		return StreetAddress;
	}
	
	public String GetCityNState() {
		return CityNState;
	}
	
	public static int getTotal() {
		return record;
	}
	private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    } 

	public String toString() {
		return String.format("#%d [%s]\nName: %s \nAddress = %s \nCity and State = %s \nBirthday = %s\n\n", thisRecord, getDateTime(), Name, StreetAddress, CityNState, b1rthday);
	}

}

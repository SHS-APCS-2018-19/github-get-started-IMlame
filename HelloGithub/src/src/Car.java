package src;

public class Car extends Vehicle {
	public static int increment;
	public static String licensePlateCar = "C" + increment;
	public Car() {
		super(licensePlateCar);

		System.out.println(increment);
		
	}
	public void openTrunk() {
		System.out.println("trunk open");
	}
	
	public void closeTrunk() {
		System.out.println("trunk closed");
	}
}

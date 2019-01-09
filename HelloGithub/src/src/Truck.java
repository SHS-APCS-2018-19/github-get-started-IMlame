package src;

public class Truck extends Vehicle{
	static int increment = 1;
	static String licensePlateTruck = "T" + increment;
	public Truck() {
		super(licensePlateTruck);
		increment += 2;
	}
	
	public void openTailgate() {
		System.out.println("Tail gate open");
	}
	
	public void closeTailgate() {
		System.out.println("Tail gate closed");
	}
}

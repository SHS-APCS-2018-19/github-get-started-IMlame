package src;
public class Car extends Vehicle {
	public static int increment = 1;

	public Car() {
		super("C" + increment);
		increment +=2;
	}

	public void openTrunk() {
		System.out.println("trunk open");
	}

	public void closeTrunk() {
		System.out.println("trunk closed");
	}

	@Override
	void getMaxSpeed() {
		System.out.println("160 mph max");
		
	}

	@Override
	void getGasMileage() {
		System.out.println("40 miles per gallon");
		
	}

	@Override
	void getWeight() {
		System.out.println("700 pounds");		
	}
}

package src;
public class Truck extends Vehicle {
	static int increment = 2;

	public Truck() {
		super("T" + increment);
		increment += 2;
	}

	public void openTailgate() {
		System.out.println("Tail gate open");
	}

	public void closeTailgate() {
		System.out.println("Tail gate closed");
	}

	public void setSpeed(int speed) {
		if (speed <= 75) {
			System.out.println("Speed set to " + speed);
			this.speed = speed;
		} else {
			System.out.println("Max speed 75. Too high!");
		}
	}

	public void increaseSpeed(int speed) {
		if (speed + this.speed <= 75) {
			System.out.println("Speed set to " + speed);
			this.speed = speed;
		} else {
			System.out.println("Max speed 75. Too high!");
		}
	}

	@Override
	void getSpeed() {
		System.out.println(speed);
		
	}

	@Override
	void getGasMileage() {
		System.out.println("20 miles per gallon");
		
	}

	@Override
	void getWeight() {
		System.out.println("1000 pounds");
		// TODO Auto-generated method stub
		
	}

}

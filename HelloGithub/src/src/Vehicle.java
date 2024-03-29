package src;
abstract class Vehicle {
	protected int speed;
	String licensePlate;
	abstract void getMaxSpeed();
	abstract void getGasMileage();
	abstract void getWeight();
	
	public Vehicle(String licensePlate) {
		this.licensePlate = licensePlate;
		System.out.println(licensePlate);
	}

	public void start() {
		System.out.println("Starting");
	}
	
	public void stop() {
		System.out.println("Stopping");
	}

	
	public void setSpeed(int speed) {
		System.out.println("Speed set to " + speed);
		this.speed = speed;
	}
 
	public void increaseSpeed(int speed) {
		System.out.println("Speed increased by " + speed);
		this.speed += speed;
	}
	
	public void decreaseSpeed(int speed) {
		System.out.println("Speed decreased by " + speed);
		this.speed -= speed;
	}

	public void turn() {
		System.out.println("turned");
	}
 }

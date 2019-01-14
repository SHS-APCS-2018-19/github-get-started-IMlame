package src;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vehicle moo = new Car(); can't access car methods
		//Vehicle moo = new Truck(); can't access truck methods
		//Truck moo = new Car(); can't compile
		//Car moo = new Truck(); can't compile
		//Truck moo = new Vehicle(); can't compile
		//Car moo = new Vehicle(); can't compile
		Truck moo = new Truck();
		Car dab = new Car();
		Car ree = new Car();
		moo.closeTailgate();
		moo.setSpeed(75);
		moo.increaseSpeed(2);
		moo.openTailgate();
		moo.stop();
		moo.turn();
		moo.getGasMileage();
	}

}

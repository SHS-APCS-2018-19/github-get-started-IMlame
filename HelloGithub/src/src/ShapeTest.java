package src;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeInterface r = new Rectangle(10,15);
		ShapeInterface c = new Circle(3);
		ShapeInterface t = new Triangle(4,5,6);
		ShapeInterface[] test = {r,c,t};
		for(ShapeInterface moo : test) {
			moo.Area();
			moo.Perimeter();
		}
	}
}

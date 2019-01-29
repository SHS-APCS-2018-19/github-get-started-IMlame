package src;

public class Circle implements ShapeInterface{
	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	public void Area() {
		System.out.println("area: " + 3.14*radius*radius);
		
	}

	@Override
	public void Perimeter() {
		System.out.println("perimeter: " + 2*3.14*radius);
		// TODO Auto-generated method stub
	}

}

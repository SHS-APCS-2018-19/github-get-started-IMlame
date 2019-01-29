package src;

public class Rectangle implements ShapeInterface {
	int width;
	int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void Area() {
		System.out.println("area: " + width * height);
		// TODO Auto-generated method stub

	}

	public void Perimeter() {
		System.out.println("perimeter: " + (2 * width + 2 * height));
		// TODO Auto-generated method stub

	}

}

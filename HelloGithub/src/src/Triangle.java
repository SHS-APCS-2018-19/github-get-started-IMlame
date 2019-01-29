package src;

public class Triangle implements ShapeInterface {
	int a;
	int b;
	int c;
	public Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void Area() {
		int s = (a+b+c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("area: " + area);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Perimeter() {
		System.out.println("perimeter:" + (a+b+c));
		// TODO Auto-generated method stub
		
	}

}

import java.util.Scanner;
public class main {
	public static void main(String[] args) {	
	Scanner in = new Scanner(System.in);
	
	System.out.println("type in first coord point");
	Point point1 = new Point(in.nextInt(),in.nextInt());
	System.out.println("type in next coord point");
	Point point2 = new Point(in.nextInt(),in.nextInt());
	
	System.out.println("distance: " + point1.getDistance(point2));
	}
}

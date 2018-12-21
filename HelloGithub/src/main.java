import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;

public class main {
	public static void main(String[] args) throws AWTException {
		Scanner in = new Scanner(System.in);
		System.out.println("type in first set of coord point");
		Point point1 = new Point(in.nextInt(), in.nextInt());
		System.out.println("type in next set of coord point");
		Point point2 = new Point(in.nextInt(), in.nextInt());
		point1.getMethods();
		while (1 == 1) {
			Robot delay = new Robot();
			System.out.println("method?");
			Scanner moo = new Scanner(System.in);
			String input = moo.nextLine();
			String temp = "";
				if(input.equals("1")) {
					System.out.println("distance: " + point1.toDistance(point2));
				}
				if(input.equals("2")) {
					System.out.println("midpoint: " + point1.midpointTo(point2));
				}
				if(input.equals("3")) {
					System.out.println("slope: " + point1.slopeTo(point2));
				}
				if(input.equals("4")) {
					System.out.println("point1 quad: " + point1.quadrant());
					System.out.println("point2 quad: " + point2.quadrant());
				}
				if(input.equals("5")) {
					System.out.println("point1: " + point1.getCoords());
					System.out.println("point2: " + point2.getCoords());
				}
				delay.delay(2000);
				Point.getMethods();
		}

	}
}

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("type in first set of coord point");
		Point point1 = new Point(in.nextInt(), in.nextInt());
		System.out.println("type in next set of coord point");
		Point point2 = new Point(in.nextInt(), in.nextInt());
		point1.getMethods();
		while (1 == 1) {
			System.out.println("method?");
			Scanner moo = new Scanner(System.in);
			String input = moo.nextLine();
			if (input.indexOf("(") > -1 && input.indexOf(".") > -1) {
				String point = input.substring(0, input.indexOf("."));
				String method = input.substring(input.indexOf(".") + 1, input.indexOf("("));
				if (point.equalsIgnoreCase("point1")) {
					if (method.equals("getX")) {
						System.out.println(point1.getX());
					} else if (method.equals("getY")) {
						System.out.println(point1.getY());
					} else if (method.equals("distanceTo")) {
						System.out.println(point1.toDistance(point2));
					} else if (method.equals("midpointTo")) {
						System.out.println(point1.midpointTo(point2));
					} else if (method.equals("slopeTo")) {
						System.out.println(point1.slopeTo(point2));
					} else if (method.equals("quadrant")) {
						System.out.println(point1.quadrant());
					} else if (method.equals("getCoords")) {
						System.out.println(point1.getCoords());
					} else {
						System.out.println("invalid method");
					}
				} else if (point.equalsIgnoreCase("point2")) {
					if (method.equals("getX")) {
						System.out.println(point2.getX());
					} else if (method.equals("getY")) {
						System.out.println(point2.getY());
					} else if (method.equals("distanceTo")) {
						System.out.println(point2.toDistance(point1));
					} else if (method.equals("midpointTo")) {
						System.out.println(point2.midpointTo(point1));
					} else if (method.equals("slopeTo")) {
						System.out.println(point2.slopeTo(point1));
					} else if (method.equals("quadrant")) {
						System.out.println(point2.quadrant());
					} else if (method.equals("getCoords")) {
						System.out.println(point2.getCoords());
					} else {
						System.out.println("invalid method");
					}
				} else {
					System.out.println("invalid point");
				}
			}
		}

	}
}

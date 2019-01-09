public class Point {
	private double x;
	private double y;
	public Point (int x, int y) {
		setX(x);
		setY(y);
	}

	public double toDistance(Point point2) {
		double distance = Math.sqrt((point2.x - this.x)*(point2.x - this.x) + (point2.y - this.y)*(point2.y - this.y));
		return distance;
	}
	public double slopeTo(Point point2) {
		return (this.y - point2.y) / (this.x - point2.x);
	}
	public String midpointTo(Point point2) {
		return "(" + (this.x + point2.x) / 2 + "," + (this.y + point2.y) / 2 + ")";
	}
	
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getCoords() {
		return "(" + x + "," + y + ")";
	}
	public String quadrant() {
		if(x > 0 && y > 0) {
			return "quadrant 1";
		} else if(x < 0 && y > 0) {
			return "quadrant 2";
		} else if(x < 0 && y < 0) {
			return "quadrant 3";
		} else if(x > 0 && y < 0) {
			return "quadrant 4";
		} else if(x == 0) {
			return "on x axis";
		} else {
			return "on y axis";
		}
	}
	public static void getMethods() {
		System.out.println("1. get distance");
		System.out.println("2. midpoint");
		System.out.println("3. slope");
		System.out.println("4. quadrant");
		System.out.println("5. coords");
	}

}

public class Point {
	private double x;
	private double y;
	private double theta;
	private double radius;
	public Point (int x, int y) {
		setX(x);
		setY(y);
		radius = Math.sqrt(x*x + y*y);
		theta  = Math.atan2(x, y);
		System.out.printf("radius: %f, theta: %f \n", radius, theta);
	}
	public String polarCoordinates() {
		radius = Math.sqrt(x*x + y*y);
		theta  = Math.atan2(x, y);
		return String.format("radius: %f, theta: %f \n", radius, theta);
	}
		
	public double toDistance(Point point2) {
		double distance = Math.sqrt((point2.x - this.x)*(point2.x - this.x) + (point2.y - this.y)*(point2.y - this.y));
		return distance;
	}
	public double slopeTo(Point point2) {
		System.out.println((this.y - point2.y) + " / " + (this.x - point2.x));
		return (this.y - point2.y) / (this.x - point2.x);
	}
	public String midpointTo(Point point2) {
		return "(" + (this.x + point2.x) / 2 + "," + (this.y + point2.y) / 2 + ")";
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
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
	public void getMethods() {
		System.out.println("point.getX() returns x value of given point");
		System.out.println("point.getY() returns y value of given point");
		System.out.println("point.distanceTo(another point) returns distance between two points");
		System.out.println("point.midpointTo(another point) returns midpoint between two points");
		System.out.println("point.slopeTo(another point) returns slope between two points");
		System.out.println("point.quadrant() returns quadrant of point");
		System.out.println("point.getCoords() returns coordinates of point"); 
	}

}
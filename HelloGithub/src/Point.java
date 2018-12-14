
public class Point {
	private int x;
	private int y;
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	public double getDistance(Point point2) {
		double distance = Math.sqrt((point2.x - this.x)*(point2.x - this.x) + (point2.y - this.y)*(point2.y - this.y));
		return distance;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getCoords() {
		return "(" + x + "," + y + ")";
	}


}
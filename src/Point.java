public class Point {
	
	public final int x;
	public final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;	
	}
	
	public static boolean equal(Point point1, Point point2) {
		if (point1.x == point2.x && point1.y == point2.y) {return true;}
		return false;
	}
}
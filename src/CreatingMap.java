import java.util.ArrayList;

public class CreatingMap {
	
	public final Point size;
	
	public CreatingMap(Point size) {
		this.size = size;
	}
	
	public static Point createWall(int x, int y) {
		
		Point wall = new Point(x, y);
		return wall;
	}
	
}

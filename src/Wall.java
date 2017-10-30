import java.util.LinkedList;

public class Wall {

	public LinkedList<Point> walls;
	public LinkedList<Point> corner;
	
	public Wall(Point wall) {
		this.walls = new LinkedList<>();
		for (int i = 0; i<=wall.x; i++) {
			this.walls.addLast(new Point(i, -1));
			this.walls.addLast(new Point(i, wall.y+1));
		}
		for (int i = 0; i<=wall.y; i++) {
			this.walls.addLast(new Point(-1, i));
			this.walls.addLast(new Point(wall.x+1, i));
		}
	}
	
	public void createWalls(Point wall) {
		for (int i = 0; i<4; i++) {
			Point randomCorner = Point.random(new Point(wall.x-2, wall.y-2));
			corner.addLast(new Point(randomCorner.x+1, randomCorner.y+1));
		}
		corner.addLast(new Point(corner.get(0).x, corner.get(1).y));
		corner.addLast(new Point(corner.get(2).x, corner.get(3).y));
	
	}
}

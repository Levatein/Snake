import java.util.LinkedList;
import java.util.Random;

public class Wall {

	public LinkedList<Point> borders;
	public LinkedList<Point> walls;
	public LinkedList<Point> corner;
	
	public Wall(Point wall) {
		Random random = new Random();
		this.borders = new LinkedList<>();
		this.corner = new LinkedList<>();
		this.walls = new LinkedList<>();
		for (int i = 0; i<=wall.x; i++) {
			this.borders.addLast(new Point(i, -1));
			this.borders.addLast(new Point(i, wall.y+1));
		}
		for (int i = 0; i<=wall.y; i++) {
			this.borders.addLast(new Point(-1, i));
			this.borders.addLast(new Point(wall.x+1, i));
		}
		for (int i = 0; i<4; i++) {
			Point randomCorner = Point.random(new Point(wall.x-2, wall.y-2));
			this.corner.addLast(new Point(randomCorner.x+1, randomCorner.y+1));
		}
		for (Point i: this.corner) {
			this.walls.addLast(i);
			for (int j = 0; j<4; j++) {
				int direction = random.nextInt(4);
				Point movement = new Point(0,0);
				if (direction == 0) {movement = Direction.UP;}
				if (direction == 1) {movement = Direction.DOWN;}
				if (direction == 2) {movement = Direction.LEFT;}
				if (direction == 3) {movement = Direction.RIGHT;}
				this.walls.addLast(new Point(i.x+movement.x, i.y+movement.y));
				this.walls.addLast(new Point(i.x+movement.x+movement.x, i.y+movement.y+movement.y));
			}
		}
	}
}

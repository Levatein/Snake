import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Wall {

	public LinkedList<Point> borders;
	public ArrayList<Point> walls;
	public LinkedList<Point> corner;

	public Wall(Point wall) {
		Random random = new Random();
		this.borders = new LinkedList<>();
		this.corner = new LinkedList<>();
		this.walls = new ArrayList<>();
		int numbersOfAngles = wall.x * wall.y / 70;
		for (int i = 0; i <= wall.x; i++) {
			this.borders.addLast(new Point(i, -1));
			this.borders.addLast(new Point(i, wall.y + 1));
		}
		for (int i = 0; i <= wall.y; i++) {
			this.borders.addLast(new Point(-1, i));
			this.borders.addLast(new Point(wall.x + 1, i));
		}
		for (int i = 0; i < numbersOfAngles; i++) {
			Point randomCorner = Point.random(new Point(wall.x - 2, wall.y - 2));
			this.corner.addLast(new Point(randomCorner.x + 1, randomCorner.y + 1));
		}
		for (Point i : this.corner) {
			this.walls.add(i);
			int direction = random.nextInt(2);
			Point movement = new Point(0, 0);
			if (direction == 0) {
				movement = Direction.UP;
			}
			if (direction == 1) {
				movement = Direction.RIGHT;
			}
			int currentX = i.x;
			int currentY = i.y;
			for (int j = 0; j <= numbersOfAngles; j++) {
				this.walls.add(new Point(i.x + currentX, i.y + currentY));
				currentX+= movement.x;
				currentX+= movement.y;
			}
		}
		ArrayList<Point> walls2 = new ArrayList<Point>();
		walls2.addAll(this.walls);
		for (Point i : walls2) {
			if (this.walls.contains(new Point(i.x+2, i.y))) {this.walls.add(new Point(i.x+1, i.y));}
			if (this.walls.contains(new Point(i.x-2, i.y))) {this.walls.add(new Point(i.x-1, i.y));}
			if (this.walls.contains(new Point(i.x, i.y+2))) {this.walls.add(new Point(i.x, i.y+1));}
			if (this.walls.contains(new Point(i.x, i.y-2))) {this.walls.add(new Point(i.x, i.y-1));}
		}
		for (Point i : walls2) {
			if (this.walls.contains(new Point(i.x+2, i.y))) {this.walls.add(new Point(i.x+1, i.y));}
			if (this.walls.contains(new Point(i.x-2, i.y))) {this.walls.add(new Point(i.x-1, i.y));}
			if (this.walls.contains(new Point(i.x, i.y+2))) {this.walls.add(new Point(i.x, i.y+1));}
			if (this.walls.contains(new Point(i.x, i.y-2))) {this.walls.add(new Point(i.x, i.y-1));}
		}
	}
}

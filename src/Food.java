import java.util.LinkedList;

public class Food {

	public Point coordinate;
	public final int value = 1;
	
	private Food(Point coordinate) {
		this.coordinate = coordinate;
	}
	
	public static Food createFood(Snake snake, Point mapSize, LinkedList<Point> walls) {
		while(true) {		
			Point point = Point.random(mapSize);
			if(!snake.snake.contains(point)&&!walls.contains(point)) {
				return new Food(point);
			}
		}
	}
}

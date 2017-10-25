import java.util.Random;

public class Food {

	public Point coordinate;
	public int value;
	
	private Food(Point coordinate, int value) {
		this.value = value;
		this.coordinate = coordinate;
	}
	
	public Point getCoordinate() {
		return coordinate;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Food createFood(Snake snake, Point mapSize) {
		Random random = new Random();
		Point location = snake.snake.get(0);
		while (snake.snake.contains(location))	{
			location = new Point(random.nextInt(mapSize.x+1), random.nextInt(mapSize.y+1));
		}
		int value = random.nextInt(2)+1;
		return new Food(location, value);
		
	}
}

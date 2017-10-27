import java.util.Random;

public class Food {

	public Point coordinate;
	public int value;
	
	private Food(Point coordinate, int value) {
		this.value = value;
		this.coordinate = coordinate;
	}
	
	public static Food createFood(Snake snake, Point mapSize) {
		Random random = new Random();
		Point location = snake.snake.get(0);
		int i = 0;
		while (true)	{
			if (Point.equal(snake.snake.get(i), location)) {
				location = new Point(random.nextInt(mapSize.x+1), random.nextInt(mapSize.y+1));
				i=0;
				continue;
			}
			if (i == snake.snake.size()-1) {
				break;
			}
			i++;
		}
		int value = random.nextInt(2)+1;
		return new Food(location, value);
		
	}
}

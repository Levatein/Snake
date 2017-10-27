import java.util.Random;

public class Food {

	public Point coordinate;
	public final int value = 1;
	
	private Food(Point coordinate) {
		//this.value = value;
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
		return new Food(location);
		
	}
}

import java.util.Arrays;
import java.util.List;

public class Snake {

	public static List<Point> snake;
	
	public Snake() {
		snake = Arrays.asList(new Point(1,0), new Point(0,0));
		}
	
	public static void movement(Snake snake, Point direction) {
		Snake.snake.add(0, Snake.snake.get(Snake.snake.size()-1));
		Snake.snake.set(0, new Point(Snake.snake.get(0).x+direction.x, Snake.snake.get(0).y+direction.y));
		Snake.snake.remove(Snake.snake.size()-1);
    }

	public static Point takeCoordinate(int i) {
		return snake.get(i);
	}
}

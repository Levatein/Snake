import java.util.ArrayList;

public class Snake {

	public ArrayList<Point> snake;
	
	public static ArrayList<Point> createSnake() {
		
		ArrayList<Point> snake = new ArrayList<Point>();
		snake.add(new Point(1, 0));
		snake.add(new Point(0, 0));
		return snake;
		}
	
	public static void movement(ArrayList<Point> snake, Point direction) {
		snake.add(0, snake.get(snake.size()-1));
		snake.set(0, new Point(snake.get(0).x+direction.x, snake.get(0).y+direction.y));
		snake.remove(snake.size()-1);
    }
}

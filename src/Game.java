import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	public Point extremePoint = new Point(5, 5); //30, 20
	public Snake snake;
	public Food food;
	public Wall walls;
	public int score;
	public Point lastPoint;
	Map<Point, GameObject> field;

	public void createField() {
		this.field = new HashMap<>();
		for (int i = 0; i <= this.extremePoint.x; i++) {
			for (int j = 0; j <= this.extremePoint.y; j++) {

				this.field.put(new Point(i, j), new Empty());
			}
		}
		for (Point i : this.walls.obstacles) {
			this.field.put(i, walls);
		}
		this.field.put(this.snake.getHead(), this.snake);
		for (int i = 0; i < this.snake.getLength(); i++) {
			this.field.put(this.snake.get(i), this.snake);
		}
		this.field.put(this.food.coordinate, this.food);
	}
	
	public Game() {
		this.snake = new Snake();
		this.walls = new Wall();
		this.walls.createWall(extremePoint);
		this.food = Food.createFood(snake, extremePoint, walls);
		this.score = 0;
	}
	
	public static char readDirection()
	{
		Scanner in = new Scanner(System.in);
		String direction = in.nextLine();
		return direction.charAt(0);
	}

	public void moveSnake() {
		char directionChar = readDirection();
		if (directionChar == 'w') {
			this.snake.move(Direction.UP);
		}
		if (directionChar == 's') {
			this.snake.move(Direction.DOWN);
		}
		if (directionChar == 'a') {
			this.snake.move(Direction.LEFT);
		}
		if (directionChar == 'd') {
			this.snake.move(Direction.RIGHT);
		}
	}
}

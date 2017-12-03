import java.util.Map;
import java.util.Scanner;

public class Game {

	public Point extremePoint = new Point(30, 20);
	public Snake snake;
	public Food food;
	public Wall walls;
	public int score;

	public Game() {
		this.snake = new Snake();
		this.walls = new Wall(extremePoint);
		this.food = Food.createFood(snake, extremePoint, walls);
		this.score = 0;
	}
	
	public char readDirection()
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

	public void snakeEatingFood(Map<Point, String> blocks, Point lastPoint) {
		if (this.snake.getHead().equals(this.food.coordinate)) {
			this.score += this.food.value;
			blocks.put(this.food.coordinate, ". ");
			this.food = Food.createFood(this.snake, this.extremePoint, this.walls);
			blocks.put(this.food.coordinate, "8 ");
			this.snake.grow(lastPoint);
		}
	}
}

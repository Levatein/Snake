import java.util.Scanner;

public class Game {

	public Snake snake;
	public Food food;
	public Point map;
	public int score;
	
	public Game() {
		this.snake = new Snake();
		this.map = new Point(20, 15);
		this.food = Food.createFood(snake, map);
		this.score = 0;
	}
	
	public void moveSnake() {
		Scanner in = new Scanner(System.in);
		String direction = in.nextLine();
		char directionChar = direction.charAt(0);
		if (directionChar == 'w') { this.snake.move(Direction.UP);}
		if (directionChar == 's') {	this.snake.move(Direction.DOWN);}
		if (directionChar == 'a') {	this.snake.move(Direction.LEFT);}
		if (directionChar == 'd') {	this.snake.move(Direction.RIGHT);}
		in.close();
	}
	
	
}

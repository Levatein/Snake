import java.util.Scanner;

public class Game {

	public Point map = new Point(10, 7);
	public Snake snake;
	public Food food;
	public Wall walls;
	public int score;
	
	public Game() {
		this.snake = new Snake();
		this.walls = new Wall(map);
		this.food = Food.createFood(snake, map, walls.walls);
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
	}
	
	
}

import java.util.Scanner;

public class Game {

	public Point map = new Point(15, 10);
	public Snake snake;
	public Food food;
	public Wall walls;
	public int score;
	
	public Game() {
		this.snake = new Snake();
		this.walls = new Wall(map);
		this.food = Food.createFood(snake, map, walls);
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
	
	public void eatingFood(String[][] matrix, Point lastPoint) {
		if (this.snake.snake.getFirst().equals(this.food.coordinate)) {
			this.score += this.food.value;
			matrix[this.food.coordinate.x][this.food.coordinate.y] = ". ";
			this.food = Food.createFood(this.snake, this.map, this.walls);
			matrix[this.food.coordinate.x][this.food.coordinate.y] = "8 ";
			this.snake.grow(lastPoint);
		}
	}
}

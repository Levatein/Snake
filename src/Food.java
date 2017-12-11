public class Food implements GameObject {

	public Point coordinate;
	public final int value = 1;

	public ApplyResult tryApply(Game game){
		game.snake.grow(game.lastPoint);
		game.food = Food.createFood(game.snake, game.extremePoint, game.walls);
		return new ApplyResult(true, new Empty());
	}
	
	private Food(Point coordinate) {
		this.coordinate = coordinate;
	}
	
	public Food() {
	}

	public static Food createFood(Snake snake, Point mapSize, Wall walls) {
		while (true) {
			Point point = Point.random(mapSize);
			if (!snake.snake.contains(point) && !walls.borders.contains(point) && !walls.obstacles.contains(point)) {
				return new Food(point);
			}
		}
	}
}

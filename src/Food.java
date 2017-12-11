public class Food implements GameObject {

	public Point coordinate;
	public final int value = 1;

	public ApplyResult tryApply(Snake snake, Point lastPoint){
		snake.grow(lastPoint);
		return new ApplyResult(true, new Empty());
	}
	
	private Food(Point coordinate) {
		this.coordinate = coordinate;
	}
	
	public Food() {
		this.coordinate = Point.ZERO;
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

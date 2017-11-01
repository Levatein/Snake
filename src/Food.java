public class Food {

	public Point coordinate;
	public final int value = 1;
	
	private Food(Point coordinate) {
		this.coordinate = coordinate;
	}
	
	public static Food createFood(Snake snake, Point mapSize, Wall walls) {
		while(true) {		
			Point point = Point.random(mapSize);
			if(!snake.snake.contains(point)&&!walls.borders.contains(point)&&!walls.walls.contains(snake.snake.getFirst())) {
				return new Food(point);
			}
		}
	}
}

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void createSnakeTest() {
		Snake snake = new Snake();
		Snake.movement(snake, new Point(1,1));
		Snake.movement(snake, new Point(1,1));
		Point point0 = Snake.takeCoordinate(0);
		Point point1 = Snake.takeCoordinate(1);
		assert(point0==new Point(1,1));
		assert(point1==new Point(1,1));
	}

}

import org.junit.jupiter.api.Test;

class SimpleTest {

	@Test
	void test() {
		Point point = new Point(0,0);
		assert(point.x==0);
		assert(point.y==0);
		
		Snake snake = new Snake();
		assert(Point.equal(snake.snake.get(0), new Point(1,0)));
		assert(Point.equal(snake.snake.get(1), new Point(0,0)));
	}

}

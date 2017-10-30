import org.junit.jupiter.api.Test;

class SimpleTest {

	@Test
	void test() {
		Point point = new Point(0,0);
		assert(point.x==0);
		assert(point.y==0);
		
		Snake snake = new Snake();
		assert(snake.snake.get(0).equals(new Point(1,0)));
		assert(snake.snake.get(1).equals(new Point(0,0)));
	}

}

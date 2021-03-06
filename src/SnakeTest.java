import org.junit.jupiter.api.Test;

class SnakeTest {

	@Test
	void Test() {
		Snake snake = new Snake();
		snake.move(Direction.UP);
		snake.move(Direction.RIGHT);
		assert(snake.snake.get(0).equals(new Point(2,1)));
		assert(snake.snake.get(1).equals(new Point(1,1)));
		
		Point lastPoint = snake.snake.getLast();
		snake.move(Direction.DOWN);
		snake.grow(lastPoint);
		assert(snake.snake.size() == 3);
		assert(snake.snake.getLast().equals(new Point(1,1)));
		
		Point map = new Point(3,3);
		snake = new Snake();
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		assert(snake.checkSnakeColide(new Wall(map)));
		
		snake = new Snake();
		snake.move(Direction.LEFT);
		snake.move(Direction.LEFT);
		assert(snake.checkSnakeColide(new Wall(map)));
	}

}
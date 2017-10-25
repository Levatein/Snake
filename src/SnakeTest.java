import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class SnakeTest {

	@Test
	void Test() {
		Snake snake = new Snake();
		snake.movement(Movement.UP);
		snake.movement(Movement.RIGHT);
		assertEquals(snake.getCoordinate(0).x, 2);
		assertEquals(snake.getCoordinate(0).y, 1);
		assertEquals(snake.getCoordinate(1).x, 1);
		assertEquals(snake.getCoordinate(1).y, 1);
		snake.movement(Movement.DOWN);
		snake.eatingFood();
		assertEquals(snake.size(), 3);
		assertEquals(snake.getCoordinate(2).x, 2);
		assertEquals(snake.getCoordinate(2).y, 2);
	}

}
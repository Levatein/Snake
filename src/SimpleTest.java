import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class SimpleTest {

	@Test
	void test() {
		Point point = new Point(0,0);
		assert(point.x==0);
		assert(point.y==0);
		
		Snake snake = new Snake();
		assertEquals(snake.getCoordinate(0).x, 1);
		assertEquals(snake.getCoordinate(0).y, 0);
		assertEquals(snake.getCoordinate(1).x, 0);
		assertEquals(snake.getCoordinate(1).y, 0);
		
	}

}

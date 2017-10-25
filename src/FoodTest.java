import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class FoodTest {

	@Test
	void Test() {
		CreatingMap map = new CreatingMap(new Point(2,0));
		Snake snake = new Snake();
		Food food = Food.createFood(snake, map.size);
		assertEquals(food.coordinate.x, 2);
		assertEquals(food.coordinate.y, 0);
	}

}
import org.junit.jupiter.api.Test;

class FoodTest {

	@Test
	void Test() {
		Point map = new Point(2,0);
		Wall walls = new Wall(map);
		Snake snake = new Snake();
		Food food = Food.createFood(snake, map, walls);
		assert(food.coordinate.equals(new Point(2,0)));
		food = Food.createFood(snake, map, walls);
		assert(food.coordinate.equals(new Point(2,0)));
		food = Food.createFood(snake, map, walls);
		assert(food.coordinate.equals(new Point(2,0)));
	}

}
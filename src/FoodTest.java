import org.junit.jupiter.api.Test;

class FoodTest {

	@Test
	void Test() {
		//��� ������ �������� ������ ���, ��� ��� ����
		Point map = new Point(2,0);
		Snake snake = new Snake();
		Food food = Food.createFood(snake, map);
		assert(Point.equal(food.coordinate, new Point(2,0)));
		food = Food.createFood(snake, map);
		assert(Point.equal(food.coordinate, new Point(2,0)));
		food = Food.createFood(snake, map);
		assert(Point.equal(food.coordinate, new Point(2,0)));
	}

}
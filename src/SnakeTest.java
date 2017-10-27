import org.junit.jupiter.api.Test;

class SnakeTest {

	@Test
	void Test() {
		//���������� ������������
		Snake snake = new Snake();
		snake.movement(Movement.UP);
		snake.movement(Movement.RIGHT);
		assert(Point.equal(snake.snake.get(0), new Point(2,1)));
		assert(Point.equal(snake.snake.get(1), new Point(1,1)));
		
		//���������� ���� ����
		snake.movement(Movement.DOWN);
		snake.eatingFood();
		assert(snake.snake.size() == 3);
		assert(Point.equal(snake.snake.get(2), new Point(2,2)));
		
		//������ ��� ������������ �� ������
		Point map = new Point(3,3);
		snake = new Snake();
		snake.movement(Movement.RIGHT);
		snake.movement(Movement.RIGHT);
		snake.movement(Movement.RIGHT);
		assert(snake.snakeDie(map));
		
		//������ ��� ������������ �� ������, ������������� ����������
		snake = new Snake();
		snake.movement(Movement.LEFT);
		snake.movement(Movement.LEFT);
		assert(snake.snakeDie(map));
		
		//������ ��� ������������ ���� � ����� �����
		snake = new Snake();
		snake.movement(Movement.RIGHT);
		snake.eatingFood();
		snake.movement(Movement.LEFT);
		assert(snake.snakeDie(map));
	}

}
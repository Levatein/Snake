import org.junit.jupiter.api.Test;

class SnakeTest {

	@Test
	void Test() {
		//корректное передвижение
		Snake snake = new Snake();
		snake.move(Direction.UP);
		snake.move(Direction.RIGHT);
		assert(snake.snake.get(0).equals(new Point(2,1)));
		assert(snake.snake.get(1).equals(new Point(1,1)));
		
		//корректный рост змеи
		snake.move(Direction.DOWN);
		snake.eatingFood();
		assert(snake.snake.size() == 3);
		assert(snake.snake.get(2).equals(new Point(2,2)));
		
		//смерть при столкновении со стеной
		Point map = new Point(3,3);
		snake = new Snake();
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		snake.move(Direction.RIGHT);
		assert(snake.snakeDie(map));
		
		//смерть при столкновении со стеной, отрицательные координаты
		snake = new Snake();
		snake.move(Direction.LEFT);
		snake.move(Direction.LEFT);
		assert(snake.snakeDie(map));
		
		//змея ест себя :I
		snake = new Snake();
		snake.move(Direction.RIGHT);
		snake.eatingFood();
		snake.eatingFood();
		snake.move(Direction.LEFT);
		snake.snakeEatItself();
		assert(snake.snake.size()==2);
	}

}
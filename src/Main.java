import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Map<Point, String> blocks = createMap(game);
		while (true) {
			printMatrix(game, blocks);
			for (int i = 0; i < game.snake.getLength(); i++) {
				blocks.put(game.snake.get(i), ". ");
			}
			Point lastPoint = game.snake.getTail();
			game.moveSnake();
			game.snake.checkSnakeCrossesItself();
			game.score = game.snake.getLength();
			if (game.snake.checkSnakeColide(game.walls)) {
				System.out.println("Game over");
				break;
			}
			game.snakeEatingFood(blocks, lastPoint);
			blocks.put(game.snake.getHead(), "H ");
			for (int i = 1; i < game.snake.getLength(); i++) {
				blocks.put(game.snake.get(i), "0 ");
			}
		}
	}

	private static Map<Point, String> createMap(Game game) {
		Map<Point, String> blocks = new HashMap<>();
		for (int i = 0; i <= game.extremePoint.x; i++) {
			for (int j = 0; j <= game.extremePoint.y; j++) {
				blocks.put(new Point(i, j), ". ");
			}
		}
		for (Point i : game.walls.obstacles) {
			try {
				blocks.put(i, "X ");
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
		blocks.put(game.snake.getHead(), "H ");
		for (int i = 1; i < game.snake.getLength(); i++) {
			blocks.put(game.snake.get(i), "0 ");
		}
		blocks.put(game.food.coordinate, "8 ");
		return blocks;
	}

	private static void printMatrix(Game game, Map<Point, String> blocks) {
		System.out.print("очки: ");
		System.out.println(game.score);
		System.out.print("где еда: ");
		System.out.print(game.food.coordinate.x);
		System.out.print(", ");
		System.out.println(game.food.coordinate.y);
		System.out.print("где голова: ");
		System.out.print(game.snake.getHead().x);
		System.out.print(", ");
		System.out.println(game.snake.getHead().y);
		for (int i = 0; i <= game.extremePoint.y; i++) {
			for (int j = 0; j <= game.extremePoint.x; j++) {
				System.out.print(blocks.get(new Point(j, game.extremePoint.y - i)));
			}
			System.out.print("\n");
		}
	}
}

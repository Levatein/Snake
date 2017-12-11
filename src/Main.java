import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		boolean flag = true;
		Game game = new Game();
		while (flag) {
			Map<Point, String> blocks = createMap(game);
			game.createField();
			printMatrix(game, blocks);
			game.moveSnake();
			game.lastPoint = game.snake.getTail();
			Point newPosition = game.snake.getHead();
			ApplyResult applyResult = game.field.get(newPosition).tryApply(game);
			if(!applyResult.isSuccess){
				System.out.println("Game Over");
				break;
			}
			game.field.put(newPosition, applyResult.replacement);
			game.score = game.snake.getLength();
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
			blocks.put(i, "X ");
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

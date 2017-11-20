public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		String[][] matrix = createMatrix(game);
		while (true) {
			printMatrix(game, matrix);
			for (int i = 0; i < game.snake.snake.size(); i++) {
				matrix[game.snake.snake.get(i).x][game.snake.snake.get(i).y] = ". ";
			}
			Point lastPoint = game.snake.snake.getLast();
			game.moveSnake();
			game.snake.snakeEatItself();
			game.score = game.snake.snake.size();
			if (game.snake.snakeDie(game.walls)) {
				System.out.println("Game over");
				break;
			}
			game.eatingFood(matrix, lastPoint);
			matrix[game.snake.head().x][game.snake.head().y] = "H ";
			for (int i = 1; i < game.snake.snake.size(); i++) {
				matrix[game.snake.snake.get(i).x][game.snake.snake.get(i).y] = "0 ";
			}
		}
	}

	private static String[][] createMatrix(Game game) {
		String[][] matrix = new String[game.extremePoint.x + 1][game.extremePoint.y + 1];
		for (int i = 0; i <= game.extremePoint.x; i++) {
			for (int j = 0; j <= game.extremePoint.y; j++) {
				matrix[i][j] = ". ";
			}
		}
		for (Point i : game.walls.obstacles) {
			try {
				matrix[i.x][i.y] = "X ";
			} catch (ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
		matrix[game.snake.head().x][game.snake.head().y] = "H ";
		for (int i = 1; i < game.snake.snake.size(); i++) {
			matrix[game.snake.snake.get(i).x][game.snake.snake.get(i).y] = "0 ";
		}
		matrix[game.food.coordinate.x][game.food.coordinate.y] = "8 ";
		return matrix;
	}

	private static void printMatrix(Game game, String[][] matrix) {
		System.out.print("����: ");
		System.out.println(game.score);
		System.out.print("��� ���: ");
		System.out.print(game.food.coordinate.x);
		System.out.print(", ");
		System.out.println(game.food.coordinate.y);
		System.out.print("��� ������: ");
		System.out.print(game.snake.head().x);
		System.out.print(", ");
		System.out.println(game.snake.head().y);
		for (int i = 0; i <= game.extremePoint.y; i++) {
			for (int j = 0; j <= game.extremePoint.x; j++) {
				System.out.print(matrix[j][game.extremePoint.y - i]);
			}
			System.out.print("\n");
		}
	}
}

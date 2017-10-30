public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		String[][] matrix = new String[game.map.x+1][game.map.y+1];
		for (int i = 0; i<=game.map.x; i++) {
			for (int j = 0; j<=game.map.y; j++) {
				matrix[i][j]=". ";
			}
		}
		matrix[game.snake.snake.getFirst().x][game.snake.snake.getFirst().y]="H ";
		for (int i = 1; i<game.snake.snake.size(); i++) {
			matrix[game.snake.snake.get(i).x][game.snake.snake.get(i).y]="0 ";
		}
		matrix[game.food.coordinate.x][game.food.coordinate.y] = "8 ";
		game.score = 0;
		printMatrix(game, matrix);
		while (true) {
			for (int i = 0; i<game.snake.snake.size(); i++) {
				matrix[game.snake.snake.get(i).x][game.snake.snake.get(i).y]=". ";
			}
			game.moveSnake();
			game.snake.snakeEatItself();
			if (game.snake.snakeDie(game.map)) {
				System.out.println("Game over");
				break;
				}
			if (game.snake.snake.getFirst().equals(game.food.coordinate)) {
				game.score += game.food.value;
				matrix[game.food.coordinate.x][game.food.coordinate.y] = ". ";
				game.food = Food.createFood(game.snake, game.map);
				matrix[game.food.coordinate.x][game.food.coordinate.y] = "8 ";
				game.snake.eatingFood();
			}
			matrix[game.snake.snake.getFirst().x][game.snake.snake.getFirst().y]="H ";
			for (int i = 1; i<game.snake.snake.size(); i++) {
				matrix[game.snake.snake.get(i).x][game.snake.snake.get(i).y]="0 ";
			}
			printMatrix(game, matrix);
		}
	}
	
	private static void printMatrix(Game game, String[][] matrix) {
		System.out.print("очки: ");
		System.out.println(game.score);
		System.out.print("где еда: ");
		System.out.print(game.food.coordinate.x);
		System.out.print(", ");
		System.out.println(game.food.coordinate.y);
		System.out.print("где голова: ");
		System.out.print(game.snake.snake.getFirst().x);
		System.out.print(", ");
		System.out.println(game.snake.snake.getFirst().y);
		for (int i = 0; i<=game.map.y; i++) {
			for (int j = 0; j<=game.map.x; j++) {
				System.out.print(matrix[j][game.map.y-i]);
			}
			System.out.print("\n");
		}
	}
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Point map = new Point(10,10);
		Snake snake = new Snake();
		Food food = Food.createFood(snake, map);
		Scanner in = new Scanner(System.in);
		String[][] matrix = new String[map.x+1][map.y+1];
		for (int i = 0; i<=map.x; i++) {
			for (int j = 0; j<=map.x; j++) {
				matrix[i][j]=". ";
			}
		}
		matrix[snake.snake.get(0).x][snake.snake.get(0).y]="H ";
		for (int i = 1; i<snake.snake.size(); i++) {
			matrix[snake.snake.get(i).x][snake.snake.get(i).y]="0 ";
		}
		matrix[food.coordinate.x][food.coordinate.y] = "8 ";
		int score = 0;
		System.out.print("����: ");
		System.out.println(score);
		System.out.print("��� ���: ");
		System.out.print(food.coordinate.x);
		System.out.print(", ");
		System.out.println(food.coordinate.y);
		System.out.print("��� ������: ");
		System.out.print(snake.snake.get(0).x);
		System.out.print(", ");
		System.out.println(snake.snake.get(0).y);
		for (int i = 0; i<=map.x; i++) {
			for (int j = 0; j<=map.y; j++) {
				System.out.print(matrix[j][map.x-i]);
			}
			System.out.print("\n");
		}
		char lastDirection = 'd';
		while (true) {
			String direction = in.nextLine();
			char directionChar = direction.charAt(0);
			for (int i = 0; i<snake.snake.size(); i++) {
				matrix[snake.snake.get(i).x][snake.snake.get(i).y]=". ";
			}
			if (directionChar == 'w') { snake.movement(Movement.UP);}
			if (directionChar == 's') {	snake.movement(Movement.DOWN);}
			if (directionChar == 'a') {	snake.movement(Movement.LEFT);}
			if (directionChar == 'd') {	snake.movement(Movement.RIGHT);}
			if (snake.snakeDie(map)) {
				System.out.println("Game over");
				break;
				}
			if (Point.equal(snake.snake.get(0), food.coordinate)) {
				score += food.value;
				matrix[food.coordinate.x][food.coordinate.y] = ". ";
				food = Food.createFood(snake, map);
				matrix[food.coordinate.x][food.coordinate.y] = "8 ";
				snake.eatingFood();
			}
			matrix[snake.snake.get(0).x][snake.snake.get(0).y]="H ";
			for (int i = 1; i<snake.snake.size(); i++) {
				matrix[snake.snake.get(i).x][snake.snake.get(i).y]="0 ";
			}
			System.out.print("����: ");
			System.out.println(score);
			System.out.print("��� ���: ");
			System.out.print(food.coordinate.x);
			System.out.print(", ");
			System.out.println(food.coordinate.y);
			System.out.print("��� ������: ");
			System.out.print(snake.snake.get(0).x);
			System.out.print(", ");
			System.out.println(snake.snake.get(0).y);
			for (int i = 0; i<=map.x; i++) {
				for (int j = 0; j<=map.y; j++) {
					System.out.print(matrix[j][map.x-i]);
				}
				System.out.print("\n");
			}
		}
	}

}
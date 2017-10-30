import java.util.LinkedList;

public class Snake {

	public LinkedList<Point> snake;

	public Snake() {
		this.snake = new LinkedList<Point>();
		this.snake.add(new Point(1, 0));
		this.snake.add(Point.ZERO);
	}

	public void move(Point direction) {
		this.snake.addFirst(this.snake.getFirst().add(direction));
		this.snake.removeLast();
	}

	public void eatingFood() {
		int x1 = this.snake.get(this.snake.size() - 1).x;
		int y1 = this.snake.get(this.snake.size() - 1).y;
		int x2 = this.snake.get(this.snake.size() - 2).x;
		int y2 = this.snake.get(this.snake.size() - 2).y;
		if (x1 == x2) {
			this.snake.add(new Point(x1, 2 * y1 - y2));
		} else {
			this.snake.add(new Point(2 * x1 - x2, y1));
		}
	}

	public boolean snakeDie(Wall walls) {
		return walls.walls.contains(this.snake.getFirst());
	}

	public void snakeEatItself() {
		for (int i = 1; i < this.snake.size(); i++) {
			if (this.snake.get(0).equals(this.snake.get(i))) {
				for (int j = this.snake.size() - 1; j >= i; j--) {
					this.snake.remove(j);
				}
			}
		}
	}
}

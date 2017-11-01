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

	public void grow(Point lastPoint) {
		this.snake.addLast(lastPoint);
	}

	public boolean snakeDie(Wall walls) {
		if (walls.borders.contains(this.snake.getFirst()) || walls.walls.contains(this.snake.getFirst())) {
			return true;}
		return false;
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

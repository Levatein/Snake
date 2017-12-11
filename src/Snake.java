import java.util.LinkedList;

public class Snake implements GameObject {

	public LinkedList<Point> snake;

	public ApplyResult tryApply(Snake s, Point lastPoint) {
		return new ApplyResult(false, this);
	}
	
	public Snake() {
		this.snake = new LinkedList<Point>();
		this.snake.add(new Point(1, 0));
		this.snake.add(Point.ZERO);
	}

	public Point get(int i) {
		return this.snake.get(i);
	}
	
	public Point getHead() {
		return this.snake.getFirst();
	}
	
	public Point getTail() {
		return this.snake.getLast();
	}
	
	public int getLength() {
		return this.snake.size();
	}

	public void move(Point direction) {
		this.snake.addFirst(this.snake.getFirst().add(direction));
		this.snake.removeLast();
	}

	public void grow(Point lastPoint) {
		this.snake.addLast(lastPoint);
	}

	public boolean checkSnakeColide(Wall walls) {
		return (walls.borders.contains(this.snake.getFirst()) || walls.obstacles.contains(this.snake.getFirst()));
	}

	public void checkSnakeCrossesItself() {
		for (int i = 1; i < this.snake.size(); i++) {
			if (this.snake.get(0).equals(this.snake.get(i))) {
				for (int j = this.snake.size() - 1; j >= i; j--) {
					this.snake.remove(j);
				}
			}
		}
	}
}

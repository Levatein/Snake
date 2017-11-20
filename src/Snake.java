import java.util.LinkedList;

public class Snake {

	public LinkedList<Point> snake;

	public Snake() {
		this.snake = new LinkedList<Point>();
		this.snake.add(new Point(1, 0));
		this.snake.add(Point.ZERO);
	}

	public Point head() { //добавила такую штуку, потому что так мне понятнее
		return this.snake.getFirst();
	}

	public void move(Point direction) { //сменила тип змеи на LinquedList и переписала эту штуку в две строки
		this.snake.addFirst(this.snake.getFirst().add(direction));
		this.snake.removeLast();
	}

	public void grow(Point lastPoint) { //переписала эут штуку
		this.snake.addLast(lastPoint);
	}

	public boolean snakeDie(Wall walls) { //переписала эту штуку
		return (walls.borders.contains(this.snake.getFirst()) || walls.obstacles.contains(this.snake.getFirst()));
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

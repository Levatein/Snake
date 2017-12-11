import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Wall implements GameObject {

	public LinkedList<Point> borders;
	public ArrayList<Point> obstacles;
	public LinkedList<Point> startPoint;

	public ApplyResult tryApply(Game game) {
		return new ApplyResult(false, this);
	}
	
	public Wall() {
	}
	
	public void createWall(Point wall) {
		Random random = new Random();
		this.borders = new LinkedList<>();
		this.startPoint = new LinkedList<>();
		this.obstacles = new ArrayList<>();
		for (int i = 0; i <= wall.x; i++) {
			this.borders.addLast(new Point(i, -1));
			this.borders.addLast(new Point(i, wall.y + 1));
		}
		for (int i = 0; i <= wall.y; i++) {
			this.borders.addLast(new Point(-1, i));
			this.borders.addLast(new Point(wall.x + 1, i));
		}
		int numbersOfAngles = wall.x * wall.y / 50; //определяет оптимальное кол-во стартовых точек для препятствий в зависимости от размера карты
		for (int i = 0; i < numbersOfAngles; i++) { //генерирует эти самые точки
			Point randomCorner = Point.random(new Point(wall.x - 2, wall.y - 2));
			this.startPoint.addLast(new Point(randomCorner.x + 1, randomCorner.y + 1));
		}
		for (Point i : this.startPoint) { //строит стены по стартовым точкам
			this.obstacles.add(i);
			int direction = random.nextInt(2);
			Point movement = new Point(0, 0);
			if (direction == 0) {
				movement = Direction.UP;
			}
			if (direction == 1) {
				movement = Direction.RIGHT;
			}
			int currentX = i.x;
			int currentY = i.y;
			for (int j = 0; j <= numbersOfAngles * 2; j++) {
				this.obstacles.add(new Point(i.x + currentX, i.y + currentY));
				currentX += movement.x;
				currentX += movement.y;
			}
		}
		ArrayList<Point> walls2 = new ArrayList<Point>();
		walls2.addAll(this.obstacles);
		for (Point i : walls2) { //проверяет и убирает места, где змея не может развернуться, или запаивает их, или очищает
			if (this.obstacles.contains(new Point(i.x + 2, i.y))) {
				this.obstacles.add(new Point(i.x + 1, i.y));
			}
			if (this.obstacles.contains(new Point(i.x - 2, i.y))) {
				this.obstacles.add(new Point(i.x - 1, i.y));
			}
			if (this.obstacles.contains(new Point(i.x, i.y + 2))) {
				this.obstacles.add(new Point(i.x, i.y + 1));
			}
			if (this.obstacles.contains(new Point(i.x, i.y - 2))) {
				this.obstacles.add(new Point(i.x, i.y - 1));
			}
			if (!this.obstacles.contains(new Point(i.x, i.y - 1)) && i.y - 2 == -1) {
				this.obstacles.remove(i);
			}
			if (!this.obstacles.contains(new Point(i.x, i.y + 1)) && i.y + 2 == wall.y + 1) {
				this.obstacles.remove(i);
			}
			if (!this.obstacles.contains(new Point(i.x - 1, i.y)) && i.x - 2 == -1) {
				this.obstacles.remove(i);
			}
			if (!this.obstacles.contains(new Point(i.x + 1, i.y)) && i.x + 2 == wall.x + 1) {
				this.obstacles.remove(i);
			}
		}
		for (Point i : walls2) { //запаивает вновь образовавшиеся места, где змея не может развернуться, а так же проверяет такие места на границах карты
			if (this.obstacles.contains(new Point(i.x + 2, i.y))) {
				this.obstacles.add(new Point(i.x + 1, i.y));
			}
			if (this.obstacles.contains(new Point(i.x - 2, i.y))) {
				this.obstacles.add(new Point(i.x - 1, i.y));
			}
			if (this.obstacles.contains(new Point(i.x, i.y + 2))) {
				this.obstacles.add(new Point(i.x, i.y + 1));
			}
			if (this.obstacles.contains(new Point(i.x, i.y - 2))) {
				this.obstacles.add(new Point(i.x, i.y - 1));
			}
			if (this.obstacles.contains(Point.ZERO) || this.obstacles.contains(new Point(1, 0))) {
				this.obstacles.remove(i);
			}
		}
	}
}

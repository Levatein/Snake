import java.util.Random;

public class Point {

	public final int x;
	public final int y;
	public static final Point ZERO = new Point(0, 0);
	public static final Point ONE = new Point(1, 1);

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public Point add(Point point) {
		return new Point(x + point.x, y + point.y);
	}

	public static Point random(Point border) {
		Random random = new Random();
		return new Point(random.nextInt(border.x + 1), random.nextInt(border.y + 1));
	}
}
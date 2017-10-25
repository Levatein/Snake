import java.util.ArrayList;

public class Snake {

	public ArrayList<Point> snake;
	
	public Snake() {
		this.snake = new ArrayList<Point>();
		this.snake.add(new Point(1,0));
		this.snake.add(new Point(0,0));
		}
	
	public void movement(Point direction) {
		this.snake.add(0, this.snake.get(this.snake.size()-1));
		this.snake.set(0, new Point(this.snake.get(1).x+direction.x, this.snake.get(1).y+direction.y));
		this.snake.remove(this.snake.size()-1);
    }
	
	public void eatingFood() {
		int x1 = this.snake.get(this.snake.size()-1).x;
		int y1 = this.snake.get(this.snake.size()-1).y;
		int x2 = this.snake.get(this.snake.size()-2).x;
		int y2 = this.snake.get(this.snake.size()-2).y;
		if (x1==x2) {
			this.snake.add(new Point(x1, 2*y1-y2));
		}
		else {
			this.snake.add(new Point(2*x1-x2, y1));
		}
    }

	public Point getCoordinate(int i) {
		return this.snake.get(i);
	}
	
	public int size() {
		return this.snake.size();
	}
}

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
			this.snake.add(new Point(x1, 2*y1-y2)); //формула во второй части определяет, вверху или внизу нужно прикрепить новый эллемент змейки
		}
		else {
			this.snake.add(new Point(2*x1-x2, y1)); //аналогично, слева или справа
		}
    }
	
	public boolean snakeDie(Point map) {
		if (this.snake.get(0).x==map.x+1 || this.snake.get(0).y==map.y+1) {return true;}
		if (this.snake.get(0).x==-1 || this.snake.get(0).y==-1) {return true;}
		for (int i = 1; i<this.snake.size(); i++) {
			if (Point.equal(this.snake.get(0), this.snake.get(i))) {return true;}
		}
		return false;
	}
}

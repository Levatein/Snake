public class Empty implements GameObject {
	
	public ApplyResult tryApply(Snake s, Point point) {
		return new ApplyResult(true, this);
	}
}
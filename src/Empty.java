public class Empty implements GameObject {
	
	public ApplyResult tryApply(Game game) {
		return new ApplyResult(true, this);
	}
}
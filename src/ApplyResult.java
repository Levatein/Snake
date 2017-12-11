public class ApplyResult {
	
	private GameObject gameObject;
	
	public ApplyResult(boolean isSuccess, GameObject gameObject) {
		this.isSuccess = isSuccess;
	    this.gameObject = gameObject;
	}

	public boolean isSuccess;
	public GameObject replacement;
}
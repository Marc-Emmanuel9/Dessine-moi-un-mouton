package mouton.exception;

public class NoFresqueException extends Exception {
	
	private String message;
	
	public NoFresqueException(final String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}

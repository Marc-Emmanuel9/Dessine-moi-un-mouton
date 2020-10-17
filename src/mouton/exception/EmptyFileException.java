package mouton.exception;

/**
 * 
 * @author Marc-Emmanuel MARTINO, Guillaume TRIJAU
 * @version 1.0
 */

public class EmptyFileException extends Exception {
	
	private String message;
	
	/**
	 * 
	 * @param message
	 */
	public EmptyFileException(final String message) {
		this.message = message;
	}
	
	/**
	 * @see Exception
	 */
	@Override
	public String getMessage() {
		return message;
	}
}

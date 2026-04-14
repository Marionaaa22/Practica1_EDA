package pr1.exceptions;

public class UnknownBookException extends RuntimeException {
	public UnknownBookException(String msg) {
		super(msg);
	}
}

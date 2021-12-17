package Pension.Management.system.exception;

public class PensionDetailsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PensionDetailsNotFoundException() {
		super();

	}

	public PensionDetailsNotFoundException(String message) {
		super(message);

	}
}

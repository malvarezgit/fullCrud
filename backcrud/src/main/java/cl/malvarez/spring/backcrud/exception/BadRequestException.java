package cl.malvarez.spring.backcrud.exception;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 9186500757591274249L;

    public BadRequestException(String detail) {
    	super(detail);
    }

}

package cl.malvarez.spring.backcrud.exception;

public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 77597966886520441L;

    public ForbiddenException(String detail) {
        super(detail);
    }

}

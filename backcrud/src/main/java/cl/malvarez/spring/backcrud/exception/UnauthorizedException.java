package cl.malvarez.spring.backcrud.exception;

public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 5549937764541402597L;

    public UnauthorizedException(String detail) {
        super(detail);
    }

}

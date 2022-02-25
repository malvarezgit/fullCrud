package cl.malvarez.spring.backcrud.exception;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7866726182418789352L;

    public NotFoundException(String detail) {
        super(detail);
    }

}

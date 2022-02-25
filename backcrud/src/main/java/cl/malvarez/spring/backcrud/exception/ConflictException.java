package cl.malvarez.spring.backcrud.exception;

public class ConflictException extends RuntimeException {
	private static final long serialVersionUID = -7447479661111554455L;

    public ConflictException(String detail) {
        super(detail);
    }

}

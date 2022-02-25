package cl.malvarez.spring.backcrud.exception;

public class BadGatewayException extends RuntimeException {
	private static final long serialVersionUID = -8068884816912033741L;

    public BadGatewayException(String detail) {
    	super(detail);
    }

}

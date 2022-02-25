package cl.malvarez.spring.backcrud.exception;

class ErrorMessage {

    private final String error;
    private final String mensaje;
    private final Integer codigo;

    ErrorMessage(Exception exception, Integer code) {
        this.error = exception.getClass().getSimpleName();
        this.mensaje = exception.getMessage();
        this.codigo = code;
    }
    
	@Override
    public String toString() {
        return "ErrorMessage{" +
                "codigo=" + codigo +
                '}';
    }

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
    
    

}

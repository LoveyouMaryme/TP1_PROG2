

public class PasDuQuenyaException extends RuntimeException {
    public PasDuQuenyaException() {
    }

    public PasDuQuenyaException( String message ) {
        super( message );
    }

    public PasDuQuenyaException( String message, Throwable cause ) {
        super( message, cause );
    }

    public PasDuQuenyaException( Throwable cause ) {
        super( cause );
    }

    public PasDuQuenyaException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}

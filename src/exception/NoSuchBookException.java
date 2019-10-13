package exception;

/**
 * @author ZhaoMin
 * @date 2019/10/10 20:50
 */
public class NoSuchBookException extends Exception {
    public NoSuchBookException(String message) {
        super(message);
    }

    public NoSuchBookException(String message, Throwable cause) {
        super(message, cause);
    }

    protected NoSuchBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoSuchBookException() {
        super();
    }

    public NoSuchBookException(Throwable cause) {
        super(cause);
    }
}

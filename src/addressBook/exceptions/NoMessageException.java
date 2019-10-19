package addressBook.exceptions;

/**
 * @author ZhaoMin
 * @date 2019/10/19 15:39
 */
public class NoMessageException extends Exception {
    public NoMessageException() {
        super();
    }

    public NoMessageException(String message) {
        super(message);
    }

    public NoMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMessageException(Throwable cause) {
        super(cause);
    }

    protected NoMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

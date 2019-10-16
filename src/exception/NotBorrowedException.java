package exception;

/**
 * @author ZhaoMin
 * @date 2019/10/16 19:37
 */
public class NotBorrowedException extends Exception {
    public NotBorrowedException() {
        super();
    }

    public NotBorrowedException(String message) {
        super(message);
    }

    public NotBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotBorrowedException(Throwable cause) {
        super(cause);
    }

    protected NotBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

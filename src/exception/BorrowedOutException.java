package exception;

/**
 * @author ZhaoMin
 * @date 2019/10/13 20:38
 */
public class BorrowedOutException extends Exception{
    public BorrowedOutException() {
        super();
    }

    public BorrowedOutException(String message) {
        super(message);
    }

    public BorrowedOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public BorrowedOutException(Throwable cause) {
        super(cause);
    }

    protected BorrowedOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

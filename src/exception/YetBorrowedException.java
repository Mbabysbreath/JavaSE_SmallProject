package exception;

/**
 * @author ZhaoMin
 * @date 2019/10/13 20:48
 */
public class YetBorrowedException extends Exception{
    public YetBorrowedException() {
        super();
    }

    public YetBorrowedException(String message) {
        super(message);
    }

    public YetBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public YetBorrowedException(Throwable cause) {
        super(cause);
    }

    protected YetBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

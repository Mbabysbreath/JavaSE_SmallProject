package addressBook.exceptions;

/**
 * @author ZhaoMin
 * @date 2019/10/19 15:46
 */
public class ImperfactException extends Exception {
    public ImperfactException() {
        super();
    }

    public ImperfactException(String message) {
        super(message);
    }

    public ImperfactException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImperfactException(Throwable cause) {
        super(cause);
    }

    protected ImperfactException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

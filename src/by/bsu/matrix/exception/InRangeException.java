package by.bsu.matrix.exception;

/**The class {@code InRangeException} is subclasses Exception
 * indicates that you ran out of matrix size.
 * Created by HP on 14.02.2022.
 * @author  Antonova Milana
 * @version 1.0
 */
public class InRangeException extends Exception {

    /**
     * Constructs a new exception with as its detail message.
     */
    public InRangeException() { }

    /**
     * Constructs a new exception with the specified detail message.       *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method
     */
    public InRangeException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     * @param  message the detail message (which is saved for later retrieval
     *         by the method)
     * @param  cause the cause (which is saved for later retrieval by the
     *         method)
     */
    public InRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message.
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables
     * @param  cause the cause (which is saved for later retrieval by the
     *         getCause() method)
     */
    public InRangeException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     */
    public InRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

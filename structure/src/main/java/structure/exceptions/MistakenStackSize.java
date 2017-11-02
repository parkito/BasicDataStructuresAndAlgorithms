package structure.exceptions;

/**
 * @author Artem Karnov @date 02.12.16.
 *         artem.karnov@t-systems.com
 **/
public class MistakenStackSize extends RuntimeException {
    /**
     * Exception with message for situation when something goes wrong in structure
     *
     * @param message message for exception
     */
    public MistakenStackSize(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when something goes wrong in structure
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public MistakenStackSize(String message, Throwable throwable) {
        super(message, throwable);
    }
}
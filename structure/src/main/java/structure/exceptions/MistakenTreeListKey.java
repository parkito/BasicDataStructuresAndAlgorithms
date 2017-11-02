package structure.exceptions;

/**
 * @author Artem Karnov @date 13.12.16.
 *         artem.karnov@t-systems.com
 **/
public class MistakenTreeListKey extends RuntimeException {
    /**
     * Exception with message for situation when something goes wrong in SearchTree
     *
     * @param message message for exception
     */
    public MistakenTreeListKey(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when
     * something goes wrong in SearchTree
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public MistakenTreeListKey(String message, Throwable throwable) {
        super(message, throwable);
    }
}
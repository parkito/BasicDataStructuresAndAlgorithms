package structure.exceptions;

/**
 * @author Artem Karnov @date 08.12.16.
 *         artem.karnov@t-systems.com
 **/
public class MistakenSearchTreeSize extends RuntimeException {
    /**
     * Exception with message for situation when something goes wrong in SearchTree
     *
     * @param message message for exception
     */
    public MistakenSearchTreeSize(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when
     * something goes wrong in SearchTree
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public MistakenSearchTreeSize(String message, Throwable throwable) {
        super(message, throwable);
    }
}

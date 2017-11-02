package com.saiu.dataStructures.exceptions;

/**
 * Created by Artyom Karnov on 15.11.16.
 * artyom-karnov@yandex.ru
 **/
public class IncorrectSizeException extends RuntimeException {
    /**
     * Exception with message for situation when something goes wrong in array
     *
     * @param message message for exception
     */
    public IncorrectSizeException(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when something goes wrong in array
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public IncorrectSizeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
package com.saiu.dataStructures.exceptions;

/**
 * Created by Artyom Karnov on 18.11.16.
 * artyom-karnov@yandex.ru
 **/
public class MistakenDeckSize extends RuntimeException {
    /**
     * Exception with message for situation when something goes wrong in structure
     *
     * @param message message for exception
     */
    public MistakenDeckSize(String message) {
        super(message);
    }

    /**
     * exception with message and throwable for situation when something goes wrong in structure
     *
     * @param message   message for exception
     * @param throwable object for exception
     */
    public MistakenDeckSize(String message, Throwable throwable) {
        super(message, throwable);
    }
}
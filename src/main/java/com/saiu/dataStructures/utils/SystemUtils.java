package com.saiu.dataStructures.utils;

import com.saiu.dataStructures.exceptions.IncorrectIndexException;
import com.saiu.dataStructures.exceptions.IncorrectSizeException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Artem Karnov @date 10/31/2017.
 * artem.karnov@t-systems.com
 */
public class SystemUtils {
    public static Object clone(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception ex) {
            return new Object();
        }
    }

    public static void checkDataStructureSize(int size) {
        if (size == Integer.MAX_VALUE) {
            throw new IncorrectSizeException("Size of structure is too large");
        } else if (size < 0) {
            throw new IncorrectSizeException("Size can't be less than 0");
        }
    }

    /**
     * Checking correctness of index
     *
     * @param index index for checking
     */
    public static void checkingIndex(int index, int size) {
        if (index < 0) {
            throw new IncorrectIndexException("Index couldn't be less than 0");
        } else if (index >= size) {
            throw new IncorrectIndexException("Index couldn't be more than list size-1");
        }
    }
}

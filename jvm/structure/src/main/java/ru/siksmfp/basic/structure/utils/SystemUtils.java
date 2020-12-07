package ru.siksmfp.basic.structure.utils;

import ru.siksmfp.kacopy.api.KaCopier;

/**
 * @author Artem Karnov @date 10/31/2017.
 * artem.karnov@t-systems.com
 */
public class SystemUtils {
    private static final KaCopier KA_COPIER = new KaCopier();

    public static <T> T clone(T t) {
        return KA_COPIER.deepCopy(t);
    }
}

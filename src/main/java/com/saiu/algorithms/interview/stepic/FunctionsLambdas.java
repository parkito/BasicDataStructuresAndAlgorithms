package com.saiu.algorithms.interview.stepic;

/**
 * @author Artem Karnov @date 24.04.17.
 *         artem.karnov@t-systems.com
 */

interface TernaryOperator {
    public int operate(int x, int y, int z);
}

public class FunctionsLambdas {
    public static int sum(int x, int y, int z) {
        TernaryOperator myFunctionalInterface = (x1, y1, z1) -> {
            return x1 + y1 * y1 + z1 * z1 * z1;
        };

        return myFunctionalInterface.operate(x, y, z);
    }

    public static void shortForm(final int x, final int y, final int z) {
        // TODO: 25.04.17 
//        IntFunction k = (x, y, z) -> {
//            x + y * y + z * z * z
//        }
    }


}

package com.saiu.algorithms.interview.codeWars;

/**
 * @author Artem Karnov @date 28.08.2017.
 * artem.karnov@t-systems.com
 */
public class ExpandForm {
    // TODO: 28.08.2017 Make it easier 
    public static String calculate(long num) {
        StringBuffer result = new StringBuffer();
        char[] str = String.valueOf(num).toCharArray();
        int[] stack = new int[str.length];

        int counter = 1;
        int stackIndex = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            int integer = (int) str[i] - 48;
            if (integer != 0) {
                stack[stackIndex] = integer * counter;
                stackIndex++;
            }
            counter *= 10;
        }
        for (int i = stackIndex - 1; i >= 0; i--) {
            result.append(stack[i] + " + ");
        }
        return result.substring(0, result.length() - 3);
    }

    public static void main(String[] args) {
        System.out.println(calculate(42));
    }
}

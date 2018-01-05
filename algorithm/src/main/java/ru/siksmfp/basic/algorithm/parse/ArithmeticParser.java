package ru.siksmfp.basic.algorithm.parse;

import ru.siksmfp.basic.structure.stack.Stack;

/**
 * @author Artem Karnov @date 1/5/2018.
 * artem.karnov@t-systems.com
 */
public class ArithmeticParser {

    public static void main(String[] args) {
        ArithmeticParser parser = new ArithmeticParser();

        System.out.println(parser.infixToPostfix("A+B+C"));
        System.out.println(parser.infixToPostfix("A+B*C"));
        System.out.println(parser.infixToPostfix("A*(B+C)"));
        System.out.println(parser.infixToPostfix("A + B * (C - D)"));
        System.out.println(parser.infixToPostfix("A*(B+C)-D/(E+F)"));
    }
//    public double parse(String arithmeticString) {
//
//    }

    private String infixToPostfix(String infixString) {
        infixString = infixString.replaceAll("\\s+", "");

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>(20);
        char[] ch = infixString.toCharArray();
        int maxI = ch.length - 1;

        for (int i = 0; i < ch.length; i++) {
            StringBuilder currentExpression = new StringBuilder();

            while (i < maxI && getOperatorPriority(ch[i]) == 0) {
                currentExpression.append(ch[i]);
                i++;
            }
            if (currentExpression.length() > 0)
                stringBuilder.append(currentExpression).append(" ");

            if (i >= maxI)
                break;

            if (operatorStack.isEmpty()) {
                operatorStack.push(ch[i]);
            } else if (ch[i] == ')') {
                clearStack(stringBuilder, operatorStack);
            } else {
                operatorStack.push(ch[i]);
            }
        }

        clearStack(stringBuilder, operatorStack);
        return stringBuilder.toString();
    }

//    private double calculateExpression(String postfix) {
//
//    }

    private void clearStack(StringBuilder stringBuilder, Stack<Character> operatorStack) {
        while (!operatorStack.isEmpty()) {
            Character currentOperator = operatorStack.pop();
            if (currentOperator != '(') {
                stringBuilder.append(currentOperator);
            }
        }
        stringBuilder.append(" ");
    }

    private int getOperatorPriority(char operator) {
        switch (operator) {
            case '(':
                return 3;
            case ')':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}

package ru.siksmfp.basic.algorithm.parse;

import ru.siksmfp.basic.structure.stack.Stack;

/**
 * @author Artem Karnov @date 1/5/2018.
 * artem.karnov@t-systems.com
 */
public class ArithmeticParser {
    private static final char OPENED_PARENTHESES = '(';
    private static final char CLOSED_PARENTHESES = ')';
    private static final char SPACE = ' ';

    public static void main(String[] args) {
        ArithmeticParser parser = new ArithmeticParser();

        System.out.println(parser.infixToPostfix("A+B+C"));
        System.out.println(parser.infixToPostfix("A+B*C"));
        System.out.println(parser.infixToPostfix("A*(B+C)"));
        System.out.println(parser.infixToPostfix("A + B * (C - D)"));
        System.out.println(parser.infixToPostfix("A*(B+C)-D/(E+F)"));
        System.out.println(parser.infixToPostfix("A*(B+C)*D"));

    }
//    public double parse(String arithmeticString) {
//
//    }

    // TODO: 1/6/2018 priorities

    private String infixToPostfix(String infixString) {
        infixString = infixString.replaceAll("\\s+", "");

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>(20);
        char[] ch = infixString.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            StringBuilder currentExpression = new StringBuilder();
            //subtract values (sophisticated value (e.g. 400.24) should be subtracted as one value)
            while (i < ch.length && getOperatorPriority(ch[i]) == 0) {
                currentExpression.append(ch[i]);
                i++;
            }
            if (currentExpression.length() > 0)
                stringBuilder.append(currentExpression).append(SPACE);
            //come to the string's end, no more symbols further.
            if (i > ch.length - 1)
                break;

            if (operatorStack.isEmpty()) {
                operatorStack.push(ch[i]);
            } else if (ch[i] == CLOSED_PARENTHESES) {
                clearStack(stringBuilder, operatorStack);
            } else {
                operatorStack.push(ch[i]);
            }
        }

        clearStack(stringBuilder, operatorStack);
        //remove last space symbol after clearStack printing
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

//    private double calculateExpression(String postfix) {
//
//    }

    private void clearStack(StringBuilder stringBuilder, Stack<Character> operatorStack) {
        while (!operatorStack.isEmpty()) {
            Character currentOperator = operatorStack.pop();
            if (currentOperator != OPENED_PARENTHESES) {
                stringBuilder.append(currentOperator).append(SPACE);
            }
        }
    }

    private int getOperatorPriority(char operator) {
        switch (operator) {
            case '(':
            case ')':
                return 4;
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}

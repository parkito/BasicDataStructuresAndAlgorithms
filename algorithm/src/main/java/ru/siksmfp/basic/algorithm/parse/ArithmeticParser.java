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
    private static final char CARET = '^';

    public static void main(String[] args) {
        ArithmeticParser parser = new ArithmeticParser();

        System.out.println(parser.infixToPostfix("A+B+C")); //A B C + +
        System.out.println(parser.infixToPostfix("A+B*C")); //A B C * +
        System.out.println(parser.infixToPostfix("A*(B+C)")); //A B C + *
        System.out.println(parser.infixToPostfix("A + B * (C - D)")); //A B C D - * +
        System.out.println(parser.infixToPostfix("A*(B+C)-D/(E+F)")); //A B C + * D E F + / -
        System.out.println(parser.infixToPostfix("A*(B+C)*D")); //A B C + * D *
        System.out.println(parser.infixToPostfix("A^B*C")); //A B ^ C *
        System.out.println(parser.infixToPostfix("(A+B)^C+D")); //A B + C ^ D +

    }
//    public double parse(String arithmeticString) {
//
//    }

    private String infixToPostfix(String infixString) {
        String infixStringWithoutSpaces = infixString.replaceAll("\\s+", "");

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>(20);
        char[] infixChars = infixStringWithoutSpaces.toCharArray();

        for (int i = 0; i < infixChars.length; i++) {
            StringBuilder currentExpression = new StringBuilder();
            //subtract values (sophisticated value (e.g. 400.24) should be subtracted as one value)
            while (i < infixChars.length && getOperatorPriority(infixChars[i]) == 0) {
                currentExpression.append(infixChars[i]);
                i++;
            }
            if (currentExpression.length() > 0)
                stringBuilder.append(currentExpression).append(SPACE);
            //come to the string's end, no more symbols further.
            if (i > infixChars.length - 1)
                break;

            else if (operatorStack.isEmpty()) {
                operatorStack.push(infixChars[i]);
            } else if (infixChars[i] == CLOSED_PARENTHESES) {
                clearStack(stringBuilder, operatorStack);
            } else if (getOperatorPriority(infixChars[i]) < getOperatorPriority(operatorStack.peek()) && operatorStack.peek() != OPENED_PARENTHESES) {
                stringBuilder.append(operatorStack.pop()).append(SPACE);
                operatorStack.push(infixChars[i]);
            } else {
                operatorStack.push(infixChars[i]);
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

package ru.siksmfp.basic.algorithm.parse;

import ru.siksmfp.basic.algorithm.math.Math;
import ru.siksmfp.basic.structure.array.dynamic.Array;
import ru.siksmfp.basic.structure.stack.Stack;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * @author Artem Karnov @date 1/5/2018.
 * artem.karnov@t-systems.com
 */
public class ArithmeticParser {
    private static final char OPENED_PARENTHESES = '(';
    private static final char CLOSED_PARENTHESES = ')';
    private static final char SPACE = ' ';
    private static final Pattern DOUBLE_PATTERN = Pattern.compile(
            "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
                    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
                    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

    public static void main(String[] args) {
        ArithmeticParser parser = new ArithmeticParser();

//        System.out.println(parser.infixToPostfix("A+B+C")); //A B C + +
//        System.out.println(parser.infixToPostfix("A+B*C")); //A B C * +
//        System.out.println(parser.infixToPostfix("A*(B+C)")); //A B C + *
//        System.out.println(parser.infixToPostfix("A + B * (C - D)")); //A B C D - * +
//        System.out.println(parser.infixToPostfix("A*(B+C)-D/(E+F)")); //A B C + * D E F + / -
//        System.out.println(parser.infixToPostfix("A*(B+C)*D")); //A B C + * D *
//        System.out.println(parser.infixToPostfix("A^B*C")); //A B ^ C *
//        System.out.println(parser.infixToPostfix("(A+B)^C+D")); //A B + C ^ D +

//        System.out.println(parser.calculateExpression("1 2 3 + +")); //6
//        System.out.println(parser.calculateExpression("1 2 3 * +")); //7
//        System.out.println(parser.calculateExpression("1 2 3 4 - * +")); //-1
//        System.out.println(parser.calculateExpression("2 2 3.1 + * 4 1 1 + / -")); //8.2
//        System.out.println(parser.calculateExpression("2 2 ^")); //4
//        System.out.println(parser.calculateExpression("2 2 2 ^ ^")); //16

        System.out.println(parser.parse("1+1")); //1
        System.out.println(parser.parse("1+1+1")); //3
        System.out.println(parser.parse("1+(1+1)")); //3
        System.out.println(parser.parse("1^(1+1)")); //1 isn't cor

    }
    public double parse(String arithmeticString) {
        String postfix = infixToPostfix(arithmeticString);
        return calculateExpression(postfix);
    }

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

    private double calculateExpression(String postfix) {
        Double result = null;
        Array<String> expressionArray = new Array();
        StringTokenizer tokenizer = new StringTokenizer(postfix, " ");
        while (tokenizer.hasMoreElements()) {
            expressionArray.add(tokenizer.nextToken());
        }

        Stack<Character> operatorStacks = new Stack<>();
        for (int i = expressionArray.size() - 1; i >= 0; i--) {
            String currentExpression = expressionArray.get(i);
            if (currentExpression.length() == 1 && getOperatorPriority(currentExpression.charAt(0)) > 0) {
                operatorStacks.push(currentExpression.charAt(0));
            } else {
                while (!operatorStacks.isEmpty()) {
                    if (result == null) {
                        result = makeArithmeticOperation(Double.valueOf(expressionArray.get(i - 1)), Double.valueOf(expressionArray.get(i)), operatorStacks.pop());
                        i--;
                    } else {
                        if (!isDouble(expressionArray.get(i))) {
                            operatorStacks.push(expressionArray.get(i).charAt(0));
                            break;
                        }
                        result = makeArithmeticOperation(result, Double.valueOf(expressionArray.get(i)), operatorStacks.pop());
                    }
                    i--;
                }
            }
        }
        return result;
    }

    private void clearStack(StringBuilder stringBuilder, Stack<Character> operatorStack) {
        while (!operatorStack.isEmpty()) {
            Character currentOperator = operatorStack.pop();
            if (currentOperator != OPENED_PARENTHESES) {
                stringBuilder.append(currentOperator).append(SPACE);
            }
        }
    }

    private double makeArithmeticOperation(double firstValue, double secondValue, char operator) {
        switch (operator) {
            case '^':
                return Math.pow(firstValue, secondValue);
            case '*':
                return firstValue * secondValue;
            case '/':
                return secondValue / firstValue;
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            default:
                throw new ArithmeticException("Unknown operator");
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

    public static boolean isDouble(String s) {
        return DOUBLE_PATTERN.matcher(s).matches();
    }
}

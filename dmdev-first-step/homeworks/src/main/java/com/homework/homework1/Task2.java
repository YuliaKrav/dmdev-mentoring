package com.homework.homework1;

/**
 * Задание 2
 * <p>
 * Даны 3 переменные:
 * <p>
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * <p>
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * <p>
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */

public class Task2 {
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final char MOD = '%';
    private static final char UNKNOWN_OPERATION = '$';
    private static final double ZERO = 0;

    public static void main(String[] args) {
        double operand1 = 24.4;
        double operand2 = 10.1;
        char operation;

        operation = ADD;
        printOperationResult(operand1, operand2, operation);

        operation = SUBTRACT;
        printOperationResult(operand1, operand2, operation);

        operation = MULTIPLY;
        printOperationResult(operand1, operand2, operation);

        operation = DIVIDE;
        printOperationResult(operand1, operand2, operation);
        printOperationResult(operand1, ZERO, operation);

        operation = MOD;
        printOperationResult(operand1, operand2, operation);
        printOperationResult(operand1, ZERO, operation);

        operation = UNKNOWN_OPERATION;
        printOperationResult(operand1, operand2, operation);
    }

    public static double calculateMathOperation(double operand1, double operand2, char operation) {
        return switch (operation) {
            case ADD -> add(operand1, operand2);
            case SUBTRACT -> subtract(operand1, operand2);
            case MULTIPLY -> multiply(operand1, operand2);
            case DIVIDE -> divide(operand1, operand2);
            case MOD -> calculateModulo(operand1, operand2);
            default -> {
                System.out.print("Unknown operation ");
                yield Double.NaN;
            }
        };
    }

    public static double add(double operand1, double operand2) {
        return operand1 + operand2;
    }

    public static double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    public static double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public static double divide(double operand1, double operand2) {
        if (operand2 == 0) {
            System.out.print("Cannot divide by zero ");
            return Double.NaN;
        }
        return operand1 / operand2;
    }

    public static double calculateModulo(double operand1, double operand2) {
        if (operand2 == 0) {
            System.out.print("Cannot calculate modulo with divisor = 0 ");
            return Double.NaN;
        }
        return operand1 % operand2;
    }

    public static void printOperationResult(double operand1, double operand2, char operation) {
        System.out.printf("%.3f %s %.3f = %.3f\n", operand1, operation, operand2, calculateMathOperation(operand1, operand2, operation));
    }
}

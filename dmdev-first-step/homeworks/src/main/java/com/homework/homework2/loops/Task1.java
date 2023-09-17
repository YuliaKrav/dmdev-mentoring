package com.homework.homework2.loops;

import java.util.Scanner;

/**
 * Задание 1
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число, а возвращать количество четных цифр (вторая функция - нечетных).
 * <p>
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */

public class Task1 {
    private static final String INPUT_PROMPT = "Please enter an integer number: ";

    public static void main(String[] args) {
        int number = readIntegerNumberFromConsole();

        int evenCount = countEvenDigits(number);
        int oddCount = countOddDigits(number);

        String evenDigitsString = getStringWithEvenDigits(number);
        String oddDigitsString = getStringWithOddDigits(number);

        System.out.println("Even digits in the number: " + evenCount + " (" + evenDigitsString + ")");
        System.out.println("Odd digits in the number: " + oddCount + " (" + oddDigitsString + ")");
    }

    private static int readIntegerNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PROMPT);
        return scanner.nextInt();
    }

    private static int countEvenDigits(int number) {
        int evenDigitsCount = 0;
        for (int currentNumber = Math.abs(number); currentNumber > 0; currentNumber /= 10) {
            int currentLastDigit = currentNumber % 10;
            evenDigitsCount += isEvenDigit(currentLastDigit) ? 1 : 0;
        }
        return evenDigitsCount;
    }

    private static int countOddDigits(int number) {
        int oddDigitsCount = 0;
        for (int currentNumber = Math.abs(number); currentNumber > 0; currentNumber /= 10) {
            int currentLastDigit = currentNumber % 10;
            oddDigitsCount += isOddDigit(currentLastDigit) ? 1 : 0;
        }
        return oddDigitsCount;
    }

    private static String getStringWithEvenDigits(int number) {
        StringBuilder evenDigits = new StringBuilder();
        for (int currentNumber = Math.abs(number); currentNumber > 0; currentNumber /= 10) {
            int currentLastDigit = currentNumber % 10;
            if (isEvenDigit(currentLastDigit)) {
                evenDigits.append(currentLastDigit).append(" ");
            }
        }
        return evenDigits.toString().trim();
    }

    private static String getStringWithOddDigits(int number) {
        StringBuilder oddDigits = new StringBuilder();
        for (int currentNumber = Math.abs(number); currentNumber > 0; currentNumber /= 10) {
            int currentLastDigit = currentNumber % 10;
            if (isOddDigit(currentLastDigit)) {
                oddDigits.append(currentLastDigit).append(" ");
            }
        }
        return oddDigits.toString().trim();
    }

    private static boolean isEvenDigit(int digit) {
        return (digit & 1) == 0;
    }

    private static boolean isOddDigit(int digit) {
        return (digit & 1) != 0;
    }
}

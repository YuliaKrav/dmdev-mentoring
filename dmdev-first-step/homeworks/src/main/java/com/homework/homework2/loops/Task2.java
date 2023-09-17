package com.homework.homework2.loops;

import java.util.Scanner;

/**
 * Задание 2
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */

public class Task2 {
    private static final String INPUT_PROMPT = "Please enter an integer number: ";

    public static void main(String[] args) {
        int number = readIntegerNumberFromConsole();
        int reversedNumber = reverseNumber(number);

        System.out.println("Original number: " + number + " -> reversed number: " + reversedNumber);
    }

    private static int readIntegerNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_PROMPT);
        return scanner.nextInt();
    }

    private static int reverseNumber(int number) {
        int reversed = 0;
        for (int currentNumber = Math.abs(number); currentNumber > 0; currentNumber /= 10) {
            reversed = reversed * 10 + currentNumber % 10;
        }
        return (number < 0) ? -reversed : reversed;
    }
}

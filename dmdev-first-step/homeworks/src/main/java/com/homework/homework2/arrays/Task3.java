package com.homework.homework2.arrays;

import java.util.Arrays;

/**
 * Задание 3
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 * [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 * [1, 9, 3]
 */

public class Task3 {
    public static void main(String[] args) {
        int[] originalArray = {-4, 0, 1, 9, 0, -18, 3};
        int[][] categorizedArrays = splitArrayIntoNegativeZeroPositive(originalArray);

        System.out.println("Original array with all numbers: " + Arrays.toString(originalArray));
        System.out.println("Array of Negative Numbers: " + Arrays.toString(categorizedArrays[0]));
        System.out.println("Array of Zeroes: " + Arrays.toString(categorizedArrays[1]));
        System.out.println("Array of Positive Numbers: " + Arrays.toString(categorizedArrays[2]));
    }

    private static int[][] splitArrayIntoNegativeZeroPositive(int[] originalArray) {
        int numberOfNegatives = countNegativeNumbers(originalArray);
        int numberOfZeroes = countZeroNumbers(originalArray);
        int numberOfPositives = countPositiveNumbers(originalArray);

        int[] negativeNumbers = fillNegativeNumbersArray(originalArray, numberOfNegatives);
        int[] zeroNumbers = fillZeroNumbersArray(originalArray, numberOfZeroes);
        int[] positiveNumbers = fillPositiveNumbersArray(originalArray, numberOfPositives);

        return new int[][]{negativeNumbers, zeroNumbers, positiveNumbers};
    }

    private static int[] fillNegativeNumbersArray(int[] originalArray, int size) {
        int[] negativeNumbersArray = new int[size];
        int index = 0;
        for (int number : originalArray) {
            if (number < 0) {
                negativeNumbersArray[index++] = number;
            }
        }
        return negativeNumbersArray;
    }

    private static int[] fillZeroNumbersArray(int[] originalArray, int size) {
        int[] zeroNumbersArray = new int[size];
        int index = 0;
        for (int number : originalArray) {
            if (number == 0) {
                zeroNumbersArray[index++] = number;
            }
        }
        return zeroNumbersArray;
    }

    private static int[] fillPositiveNumbersArray(int[] originalArray, int size) {
        int[] positiveNumbersArray = new int[size];
        int index = 0;
        for (int number : originalArray) {
            if (number > 0) {
                positiveNumbersArray[index++] = number;
            }
        }
        return positiveNumbersArray;
    }

    private static int countNegativeNumbers(int[] originalArray) {
        int countNegativeNumbers = 0;
        for (int currentNumber : originalArray) {
            if (currentNumber < 0) {
                countNegativeNumbers++;
            }
        }
        return countNegativeNumbers;
    }

    private static int countZeroNumbers(int[] originalArray) {
        int countZeroNumbers = 0;
        for (int currentNumber : originalArray) {
            if (currentNumber == 0) {
                countZeroNumbers++;
            }
        }
        return countZeroNumbers;
    }

    private static int countPositiveNumbers(int[] originalArray) {
        int countPositiveNumbers = 0;
        for (int currentNumber : originalArray) {
            if (currentNumber > 0) {
                countPositiveNumbers++;
            }
        }
        return countPositiveNumbers;
    }
}

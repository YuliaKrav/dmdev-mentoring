package com.homework.homework2.arrays;

import java.util.Arrays;

/**
 * Задание 2
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только
 * те элементы, которые больше этого среднего арифметического.
 */

public class Task2 {
    public static void main(String[] args) {
        char[] inputCharacters = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] asciiValues = convertCharsToAsciiValues(inputCharacters);
        System.out.println("Original char array: " + Arrays.toString(inputCharacters));
        System.out.println("Converted int array: " + Arrays.toString(asciiValues));

        double calculatedAverage = calculateAverageOfIntArray(asciiValues);
        System.out.println("Average in int array: " + calculatedAverage);

        int[] elementsAboveAverage = filterElementsByGreaterAverage(asciiValues, calculatedAverage);
        System.out.println("Elements greater than average: " + Arrays.toString(elementsAboveAverage));
    }

    private static int[] convertCharsToAsciiValues(char[] inputCharacters) {
        int[] asciiValues = new int[inputCharacters.length];
        for (int i = 0; i < inputCharacters.length; i++) {
            asciiValues[i] = inputCharacters[i];
        }
        return asciiValues;
    }

    private static double calculateAverageOfIntArray(int[] inputNumbers) {
        int totalSum = 0;
        for (int number : inputNumbers) {
            totalSum += number;
        }
        return (double) totalSum / inputNumbers.length;
    }

    private static int[] filterElementsByGreaterAverage(int[] inputNumbers, double averageValue) {
        int numberOfElementsAboveAverage = countElementsAboveAverage(inputNumbers, averageValue);

        int[] filteredNumbers = new int[numberOfElementsAboveAverage];
        int insertionIndex = 0;
        for (int number : inputNumbers) {
            if (number > averageValue) {
                filteredNumbers[insertionIndex++] = number;
            }
        }
        return filteredNumbers;
    }

    private static int countElementsAboveAverage(int[] inputNumbers, double averageValue) {
        int countAboveAvarage = 0;
        for (int number : inputNumbers) {
            if (number > averageValue) {
                countAboveAvarage++;
            }
        }
        return countAboveAvarage;
    }
}

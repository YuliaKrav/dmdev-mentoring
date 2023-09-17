package com.homework.homework2.arrays;

import java.util.Arrays;

/**
 * Задание 1
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */

public class Task1 {
    public static void main(String[] args) {
        int[] inputNumbers = {3, 5, -6, 3, 2, -9, 0, -123};
        int[] processedNumbers = removeNegativesAndMultiplyByLength(inputNumbers);
        System.out.println(Arrays.toString(inputNumbers) + " -> " + Arrays.toString(processedNumbers));
    }

    private static int[] removeNegativesAndMultiplyByLength(int[] inputNumbers) {
        int[] positiveNumbers = getOnlyPositiveArrayNumbers(inputNumbers);
        int lengthMultiplier = positiveNumbers.length;
        return multiplyArrayElementsByMultiplier(positiveNumbers, lengthMultiplier);
    }

    private static int[] getOnlyPositiveArrayNumbers(int[] inputNumbers) {
        int countOfPositiveNumbers = countPositiveElements(inputNumbers);

        int[] positiveNumbers = new int[countOfPositiveNumbers];
        int insertionIndex = 0;
        for (int number : inputNumbers) {
            if (number >= 0) {
                positiveNumbers[insertionIndex++] = number;
            }
        }
        return positiveNumbers;
    }

    private static int countPositiveElements(int[] inputNumbers) {
        int countOfPositiveNumbers = 0;
        for (int number : inputNumbers) {
            if (number >= 0) {
                countOfPositiveNumbers++;
            }
        }
        return countOfPositiveNumbers;
    }

    public static int[] multiplyArrayElementsByMultiplier(int[] inputNumbers, int multiplier) {
        int[] multipliedNumbers = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            multipliedNumbers[i] = inputNumbers[i] * multiplier;
        }
        return multipliedNumbers;
    }
}

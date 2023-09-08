package com.homework.homework1;

/**
 * Задание 1
 * <p>
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * <p>
 * Протестировать функцию в main.
 */

public class Task1 {
    private static final int FIRST_QUARTER_MAX = 14;
    private static final int SECOND_QUARTER_MAX = 29;
    private static final int THIRD_QUARTER_MAX = 44;
    private static final int FOURTH_QUARTER_MAX = 59;

    public static void main(String[] args) {
        printMinutesQuarter(-5);
        printMinutesQuarter(0);
        printMinutesQuarter(5);
        printMinutesQuarter(17);
        printMinutesQuarter(37);
        printMinutesQuarter(47);
    }

    public static void printMinutesQuarter(int minutes) {
        String prefixMinutes = "Minutes: " + minutes + " - ";

        if (minutes < 0) {
            System.out.println(prefixMinutes + "negative minutes value is not allowed");
            return;
        }

        if (minutes <= FIRST_QUARTER_MAX) {
            System.out.println(prefixMinutes + "in the first quarter of the hour.");
        } else if (minutes <= SECOND_QUARTER_MAX) {
            System.out.println(prefixMinutes + "in the second quarter of the hour.");
        } else if (minutes <= THIRD_QUARTER_MAX) {
            System.out.println(prefixMinutes + "in the third quarter of the hour.");
        } else if (minutes <= FOURTH_QUARTER_MAX) {
            System.out.println(prefixMinutes + "in the fourth quarter of the hour.");
        } else {
            System.out.println(prefixMinutes + "invalid minutes value.");
        }
    }
}

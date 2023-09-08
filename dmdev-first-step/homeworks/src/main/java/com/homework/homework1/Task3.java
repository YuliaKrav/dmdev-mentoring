package com.homework.homework1;

/**
 * Задание 3
 * <p>
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * <p>
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */

public class Task3 {
    private static final double EPSILON = 0.000001;

    public static void main(String[] args) {
        int triangleSideA1 = 3;
        int triangleSideB1 = 4;

        int triangleSideA2 = 4;
        int triangleSideB2 = 3;

        int triangleSideA3 = 7;
        int triangleSideB3 = 3;

        if (isValidSide(triangleSideA1) && isValidSide(triangleSideB1)
                && isValidSide(triangleSideA2) && isValidSide(triangleSideB2)
                && isValidSide(triangleSideA3) && isValidSide(triangleSideB3)) {

            double triangleArea1 = calculateRightTriangleArea(triangleSideA1, triangleSideB1);
            double triangleArea2 = calculateRightTriangleArea(triangleSideA2, triangleSideB2);
            double triangleArea3 = calculateRightTriangleArea(triangleSideA3, triangleSideB3);

            compareTriangleAreas(triangleArea1, triangleArea2);
            compareTriangleAreas(triangleArea1, triangleArea3);
        } else {
            System.out.println("Invalid side length(s) provided.");
        }
    }

    public static boolean isValidSide(int side) {
        return side > 0;
    }

    public static double calculateRightTriangleArea(int side1, int side2) {
        return 0.5 * side1 * side2;
    }

    public static void compareTriangleAreas(double area1, double area2) {
        if (Math.abs(area1 - area2) < EPSILON) {
            System.out.printf("The areas of two triangles are equal. %.3f = %.3f\n", area1, area2);
        } else if (area1 > area2) {
            System.out.printf("The areas of the first triangles is larger than the second one. %.3f > %.3f\n", area1, area2);
        } else {
            System.out.printf("The areas of the first triangles is less than the second one. %.3f < %.3f\n", area1, area2);
        }
    }
}

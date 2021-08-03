package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {

    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double sumOfDiffAndDiv(double first, double second) {
        return difference(first, second) + division(first, second);
    }

    public  static double sumOfAllMethodsResults(double first, double second) {
        return sum(first, second) + multiply(first, second)
                + difference(first, second) + division(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат расчета равен: "
                + sumAndMultiply(10, 20));
        System.out.println("Сумма разности 20 и 10 и деления 20 на 10 равна: "
                + sumOfDiffAndDiv(20, 10));
        System.out.println("Сумма результатов четырех методов для 30 и 10 равна: "
                + sumOfAllMethodsResults(30, 10));
    }
}

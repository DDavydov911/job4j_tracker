package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {

    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат расчета равен: " + sumAndMultiply(10, 20));
        System.out.println("Результат вычитания 10 из 20 равен: " + difference(20, 10));
        System.out.println("Результат возведения 2 в 4 степень равен: " + power(2, 4));
        System.out.println("Результат извлечения квадратного корня из 4 равен: " + squareRoot(4));
    }
}

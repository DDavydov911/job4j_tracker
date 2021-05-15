package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            int matches = 0;
            while (matches < 1 || matches > 3) {
                System.out.println(player + " введите число от 1 до 3:");
                matches = Integer.parseInt(input.nextLine());
            }
            turn = !turn;
            count -= matches;
            count = count < 0 ? 0 : count;
            System.out.printf("На столе остaлось %d спичек%n", count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
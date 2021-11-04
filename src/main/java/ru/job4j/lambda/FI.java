package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("images 11", 20),
                new Attachment("image 3", 120),
                new Attachment("image 20", 23)
        };
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };

        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());
        /*
         1. Объявляем тип переменной Comparator
         2. Указываем тип обобщения "Attachment", которое так же будет типом
            переменных для параметров left и right
         3. Присваевем переменной ссылку на лямбду
         4. Указываем в скобках параметры left и right
         5. После стрелки описываем тело метода который вернет сравнение строковых
            значение полей name аргументов left и right
        */
        Comparator<Attachment> cmpDescSize = (left, right) -> Integer.compare(
                right.getName().length(), left.getName().length());
        /*
         1. Объявляем тип переменной Comparator
         2. Указываем тип обобщения "Attachment", которое так же будет типом
            переменных для параметров left и right
         3. Присваевем переменной ссылку на лямбду
         4. Указываем в скобках параметры left и right
         5. После стрелки описываем тело метода, который вернет разницу между
            длинной строкового значения поля name аргумента right из длинной
            строкового значения поля name аргумента left
         */
    }
}

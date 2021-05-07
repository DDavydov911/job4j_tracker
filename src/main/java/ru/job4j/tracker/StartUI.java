package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        LocalDateTime tt = item.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Дата: yyyy-MM-dd Время: HH:mm:ss ууу, прикольно!");
        System.out.println(tt.format(formatter));
    }
}

package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGropeNumber(11);
        student.setInterDate(LocalDate.of(2020, 9, 1));
        System.out.println("Студент " + student.getFullName() + ", группа №"
                + student.getGropeNumber() + ", дата поступления: "
                + student.getInterDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}

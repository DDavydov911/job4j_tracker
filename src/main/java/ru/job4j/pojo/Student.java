package ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String fullName;
    private int gropeNumber;
    private LocalDate interDate;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGropeNumber() {
        return gropeNumber;
    }

    public void setGropeNumber(int gropeNumber) {
        this.gropeNumber = gropeNumber;
    }

    public LocalDate getInterDate() {
        return interDate;
    }

    public void setInterDate(LocalDate interDate) {
        this.interDate = interDate;
    }
}
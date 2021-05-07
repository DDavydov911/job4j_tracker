package ru.job4j.oop;

public class Doctor extends Profession {
    Boolean hiGraduated;

    Doctor(){
    }

    Doctor(String name, String surname, String education, String birthday, Boolean graduated){
        super(name, surname, education, birthday);
        this.hiGraduated = graduated;
    }


    public void visitPatient() {
    }

    public void diagnose() {
    }

    public void healSmth() {
    }
}

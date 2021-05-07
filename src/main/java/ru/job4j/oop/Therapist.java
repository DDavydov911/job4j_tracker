package ru.job4j.oop;

public class Therapist extends Doctor {
    Boolean hasLicence;

    Therapist(){
    }

    Therapist(String name, String surname, String education, String birthday, Boolean graduated, Boolean hasLicence) {
        super(name, surname, education, birthday, graduated);
        this.hasLicence = hasLicence;
    }

    public void healFlu() {
    }
}

package ru.job4j.oop;

public class Engineer extends Profession {
    Boolean hasWorkPermit;

    Engineer(){
    }

    Engineer(String name, String surname, String education, String birthday, Boolean hasWorkPermit){
        super(name, surname, education, birthday);
        this.hasWorkPermit = hasWorkPermit;
    }

    public void projecting() {
    }
}

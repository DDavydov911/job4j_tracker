package ru.job4j.oop;

public class Engineer extends Profession {
    private Boolean hasWorkPermit;

    public Engineer(){
    }

    public Engineer(String name, String surname, String education, String birthday, Boolean hasWorkPermit){
        super(name, surname, education, birthday);
        this.hasWorkPermit = hasWorkPermit;
    }

    public void projecting() {
    }
}

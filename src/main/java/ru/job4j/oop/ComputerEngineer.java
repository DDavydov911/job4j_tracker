package ru.job4j.oop;

public class ComputerEngineer extends Engineer {
    private Boolean hasCompGrade;

    public ComputerEngineer() {
    }

    public ComputerEngineer(String name, String surname, String education,
                            String birthday, Boolean hasWorkPermit,
                            Boolean hasCompGrade) {
        super(name, surname, education, birthday, hasWorkPermit);
        this.hasCompGrade = hasCompGrade;
    }

    public void doTest() {
    }
}

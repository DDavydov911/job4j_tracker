package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println(active + " " + status + " " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 3, "We are");
        error.show();
        Error error1 = new Error();
        error1.show();
    }
}
